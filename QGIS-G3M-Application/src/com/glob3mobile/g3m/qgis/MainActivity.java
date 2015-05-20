

package com.glob3mobile.g3m.qgis;

import java.util.ArrayList;

import org.glob3.mobile.generated.G3MContext;
import org.glob3.mobile.generated.GInitializationTask;
import org.glob3.mobile.generated.LayerSet;
import org.glob3.mobile.generated.OSMLayer;
import org.glob3.mobile.generated.TimeInterval;
import org.glob3.mobile.generated.URLTemplateLayer;
import org.glob3.mobile.specific.G3MBuilder_Android;
import org.glob3.mobile.specific.G3MWidget_Android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.glob3mobile.g3m.qgis.parser.ScenarioLoaderListener;
import com.glob3mobile.g3m.qgis.parser.ScenarioParser;
import com.globl3mobile.g3m.qgis.model.BaseLayers;
import com.globl3mobile.g3m.qgis.model.LayerData;
import com.globl3mobile.g3m.qgis.model.Scenario;

import con.glob3mobile.g3m.qgis.R;


public class MainActivity
         extends
            Activity
         implements
            ScenarioLoaderListener {

   private static final String TAG      = "MainActivity";
   private G3MWidget_Android   _widgetAndroid;
   private G3MBuilder_Android  _builder;
   boolean                     _waiting = false;
   private LayerSet            _lsParsed;


   @Override
   protected void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


      _builder = new G3MBuilder_Android(getApplicationContext());
      _builder.setInitializationTask(initQgisScenario());

      _lsParsed = new LayerSet();
      _builder.getPlanetRendererBuilder().setLayerSet(_lsParsed);

      _widgetAndroid = _builder.createWidget();
      final ScenarioParser sp = new ScenarioParser();
      sp.parseScenario(MainActivity.this, "file:///scenario.json", _widgetAndroid.getG3MContext());


      final RelativeLayout glob3Layout = (RelativeLayout) findViewById(R.id.glob3);
      glob3Layout.setVisibility(View.VISIBLE);
      glob3Layout.addView(_widgetAndroid);

   }


   private GInitializationTask initQgisScenario() {
      final GInitializationTask initializationTask = new GInitializationTask() {

         @Override
         public boolean isDone(final G3MContext context) {
            // TODO Auto-generated method stub
            return _waiting;
         }


         @Override
         public void run(final G3MContext context) {

         }
      };
      return initializationTask;
   }


   @Override
   public void onError(final String message) {
      // TODO Auto-generated method stub

   }


   @Override
   public void onScenarioRead(final Scenario scenario) {
      Log.d(TAG, "The parsed name of scenario:" + scenario.getName());

      setBaseLayers(scenario.getLayers());

      _waiting = true;
   }


   private void setBaseLayers(final ArrayList<LayerData> layers) {
      for (int i = 0; i < layers.size(); i++) {
         final LayerData layer = layers.get(i);

         final URLTemplateLayer layerTemplate = BaseLayers.getBaselLayerByName(layer.getName());

         //         if (i != 0) {
         //            layerTemplate.setEnable(false);
         //         }

         // _lsParsed.addLayer(layerTemplate);
         _lsParsed.addLayer(new OSMLayer(TimeInterval.forever()));
      }
   }
}
