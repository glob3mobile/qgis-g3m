

package com.glob3mobile.g3m.qgis;

import java.util.ArrayList;

import org.glob3.mobile.generated.AltitudeMode;
import org.glob3.mobile.generated.G3MContext;
import org.glob3.mobile.generated.GEO2DLineStringGeometry;
import org.glob3.mobile.generated.GEO2DMultiLineStringGeometry;
import org.glob3.mobile.generated.GEO2DMultiPolygonGeometry;
import org.glob3.mobile.generated.GEO2DPointGeometry;
import org.glob3.mobile.generated.GEO2DPolygonGeometry;
import org.glob3.mobile.generated.GEOLineRasterSymbol;
import org.glob3.mobile.generated.GEOMarkSymbol;
import org.glob3.mobile.generated.GEOPolygonRasterSymbol;
import org.glob3.mobile.generated.GEORenderer;
import org.glob3.mobile.generated.GEOSymbol;
import org.glob3.mobile.generated.GEOSymbolizer;
import org.glob3.mobile.generated.GInitializationTask;
import org.glob3.mobile.generated.Geodetic3D;
import org.glob3.mobile.generated.JSONObject;
import org.glob3.mobile.generated.Layer;
import org.glob3.mobile.generated.LayerSet;
import org.glob3.mobile.generated.Mark;
import org.glob3.mobile.generated.MarkTouchListener;
import org.glob3.mobile.generated.URL;
import org.glob3.mobile.specific.G3MBuilder_Android;
import org.glob3.mobile.specific.G3MWidget_Android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.glob3mobile.g3m.qgis.model.BaseLayers;
import com.glob3mobile.g3m.qgis.model.LayerData;
import com.glob3mobile.g3m.qgis.model.Scenario;
import com.glob3mobile.g3m.qgis.model.Symbology;
import com.glob3mobile.g3m.qgis.parser.ScenarioLoaderListener;
import com.glob3mobile.g3m.qgis.parser.ScenarioParser;

import con.glob3mobile.g3m.qgis.R;


public class MainActivity
         extends
            Activity
         implements
            ScenarioLoaderListener {

   private static final String _cloudServer = "http://130.206.115.80/g3m-qgis/";
   private static final String TAG          = "MainActivity";
   private G3MWidget_Android   _widgetAndroid;
   private G3MBuilder_Android  _builder;
   boolean                     _waiting     = false;
   private LayerSet            _lsParsed;
   private String              _appName;
   private GEORenderer         _vectorialRenderer;


   @Override
   protected void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


      final SharedPreferences prefs = this.getSharedPreferences("com.glob3mobile.g3m.qgis", MainActivity.MODE_PRIVATE);
      _appName = prefs.getString("appName", "default");

      if (_appName.equals("default")) {
         // Create custom dialog object
         final Dialog dialog = new Dialog(MainActivity.this);
         // Include dialog.xml file
         dialog.setContentView(R.layout.appnamedialog);
         // Set dialog title
         dialog.setTitle("Set the app name");

         final TextView appNameTW = (TextView) dialog.findViewById(R.id.appname);
         final Button buttonOK = (Button) dialog.findViewById(R.id.ok);
         final Button cancel = (Button) dialog.findViewById(R.id.cancel);

         appNameTW.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(final CharSequence s,
                                      final int start,
                                      final int before,
                                      final int count) {
               if (s.toString().length() > 0) {
                  buttonOK.setEnabled(true);
               }
            }


            @Override
            public void afterTextChanged(final Editable s) {

            }


            @Override
            public void beforeTextChanged(final CharSequence s,
                                          final int start,
                                          final int count,
                                          final int after) {

            }
         });


         buttonOK.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {

               prefs.edit().putString("appName", appNameTW.getText().toString()).apply();

               dialog.dismiss();
               new AlertDialog.Builder(MainActivity.this).setTitle("Closing App").setMessage(
                        "The app name has been set to: "
                                 + prefs.getString("appName", "default")
                                 + ". \n If you want to change"
                                 + " the application name you must re-install it. The app is going to close , on next start you can see your deployed application").setPositiveButton(
                                          android.R.string.yes, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(final DialogInterface dialog,
                                               final int which) {
                              System.exit(0);
                           }
                        }).show();


            }
         });


         cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
               dialog.dismiss();
            }
         });

         dialog.show();


      }


      _builder = new G3MBuilder_Android(getApplicationContext());
      _builder.setInitializationTask(initQgisScenario());

      _lsParsed = new LayerSet();
      _builder.getPlanetRendererBuilder().setLayerSet(_lsParsed);
      _vectorialRenderer = _builder.createGEORenderer(Symbolizer);

      _widgetAndroid = _builder.createWidget();


      final RelativeLayout glob3Layout = (RelativeLayout) findViewById(R.id.glob3);
      glob3Layout.addView(_widgetAndroid);

   }


   private GInitializationTask initQgisScenario() {
      final GInitializationTask initializationTask = new GInitializationTask() {

         @Override
         public boolean isDone(final G3MContext context) {


            runOnUiThread(new Runnable() {

               @Override
               public void run() {
                  findViewById(R.id.glob3).setVisibility(View.VISIBLE);
               }
            });

            return _waiting;
         }


         @Override
         public void run(final G3MContext context) {
            final ScenarioParser sp = new ScenarioParser();
            sp.parseScenario(MainActivity.this, _cloudServer + _appName + "/" + _appName + ".json", context);
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

      setLayers(scenario.getBaseLayers());
      setLayers(scenario.getOverlayLayers());
      setVectorialLayers(scenario.getLayers());

      _waiting = true;
   }


   private void setVectorialLayers(final ArrayList<LayerData> layers) {


      for (int i = 0; i < layers.size(); i++) {
         final LayerData layer = layers.get(i);
         _vectorialRenderer.loadJSON(new URL(_cloudServer + _appName + "/layers/" + layer.getName() + ".json"));
      }
   }


   private void setLayers(final ArrayList<LayerData> layers) {


      for (int i = 0; i < layers.size(); i++) {
         final LayerData layer = layers.get(i);

         final Layer layerTemplate = BaseLayers.createBaseLayerByName(layer.getName());

         if (i != 0) {
            layerTemplate.setEnable(false);
         }

         _lsParsed.addLayer(layerTemplate);

      }
   }


   GEOSymbolizer Symbolizer = new GEOSymbolizer() {

                               @Override
                               public ArrayList<GEOSymbol> createSymbols(final GEO2DMultiPolygonGeometry geometry) {
                                  // TODO Auto-generated method stub
                                  return null;
                               }


                               @Override
                               public ArrayList<GEOSymbol> createSymbols(final GEO2DPolygonGeometry geometry) {
                                  final ArrayList<GEOSymbol> symbols = new ArrayList<GEOSymbol>();
                                  symbols.add(new GEOPolygonRasterSymbol(geometry.getPolygonData(),
                                           Symbology.createPolygonLineRasterStyle(geometry),
                                           Symbology.createPolygonSurfaceRasterStyle(geometry)));

                                  return symbols;
                               }


                               @Override
                               public ArrayList<GEOSymbol> createSymbols(final GEO2DMultiLineStringGeometry geometry) {
                                  // TODO Auto-generated method stub
                                  return null;
                               }


                               @Override
                               public ArrayList<GEOSymbol> createSymbols(final GEO2DLineStringGeometry geometry) {
                                  final ArrayList<GEOSymbol> symbols = new ArrayList<GEOSymbol>();
                                  symbols.add(new GEOLineRasterSymbol(geometry.getCoordinates(),
                                           Symbology.createLineRasterStyle(geometry)));
                                  return symbols;
                               }


                               @Override
                               public ArrayList<GEOSymbol> createSymbols(final GEO2DPointGeometry geometry) {

                                  final ArrayList<GEOSymbol> result = new ArrayList<GEOSymbol>();

                                  final JSONObject properties = geometry.getFeature().getProperties();

                                  final String name = properties.getAsString("name", "");


                                  final MarkTouchListener markListener = new MarkTouchListener() {
                                     @Override
                                     public boolean touchedMark(final Mark mark) {
                                        runOnUiThread(new Runnable() {
                                           @Override
                                           public void run() {
                                              new AlertDialog.Builder(MainActivity.this) //
                                              .setTitle("Restaurant Name") //
                                              .setMessage(name) //
                                              .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                 @Override
                                                 public void onClick(final DialogInterface dialog,
                                                                     final int which) {
                                                    // continue with delete
                                                 }
                                              }) //
                                              .show();
                                           }
                                        });

                                        return true;
                                     }
                                  };

                                  final Mark mark = new Mark( //
                                           new URL("file:///airport.png"), //
                                           new Geodetic3D(geometry.getPosition(), 0), //
                                           AltitudeMode.RELATIVE_TO_GROUND, //
                                           500000000, //
                                           null, //
                                           false, //
                                           markListener, //
                                           true);


                                  result.add(new GEOMarkSymbol(mark));
                                  return result;

                               }
                            };


}
