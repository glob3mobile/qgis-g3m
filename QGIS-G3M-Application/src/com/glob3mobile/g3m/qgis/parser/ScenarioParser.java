

package com.glob3mobile.g3m.qgis.parser;

import java.util.ArrayList;

import org.glob3.mobile.generated.G3MContext;
import org.glob3.mobile.generated.GEOSymbolizer;
import org.glob3.mobile.generated.IBufferDownloadListener;
import org.glob3.mobile.generated.IByteBuffer;
import org.glob3.mobile.generated.IDownloader;
import org.glob3.mobile.generated.IJSONParser;
import org.glob3.mobile.generated.JSONArray;
import org.glob3.mobile.generated.JSONObject;
import org.glob3.mobile.generated.TimeInterval;
import org.glob3.mobile.generated.URL;

import com.globl3mobile.g3m.qgis.model.LayerData;
import com.globl3mobile.g3m.qgis.model.Scenario;
import com.globl3mobile.g3m.qgis.model.LayerData.type;


public class ScenarioParser {

   public GEOSymbolizer parseSimbology(final String symbologyPath,
                                       final G3MContext contex) {
      return null;
   }


   public void parseScenario(final ScenarioLoaderListener scenarioListener,
                             final String scenarioPath,
                             final G3MContext context)

   {


      final IDownloader downloader = context.getDownloader();

      final IBufferDownloadListener listener = new IBufferDownloadListener() {

         @Override
         public void onDownload(final URL url,
                                final IByteBuffer buffer,
                                final boolean expired) {


            final Scenario scenario = new Scenario();
            final String response = buffer.getAsString();
            final JSONObject scenarioListObject = IJSONParser.instance().parse(response, false).asObject();


            final JSONObject settings = scenarioListObject.getAsObject("Settings");
            scenario.setName(settings.getAsString("Title").value());

            final JSONArray baselayers = scenarioListObject.getAsArray("Base layers");
            final ArrayList<LayerData> baseLayersArray = new ArrayList<LayerData>();

            for (int i = 0; i < baselayers.size(); i++) {
               final LayerData ld = new LayerData();
               ld.setType(type.templateLayer);
               ld.setName(baselayers.getAsString(i).value());
               baseLayersArray.add(ld);
            }

            scenario.setBaseLayers(baseLayersArray);

            //            final String response = buffer.getAsString();
            //            final JSONObject scenarioListObject = IJSONParser.instance().parse(response, false).asObject();
            //
            //            final JSONArray scenarioArray = scenarioListObject.getAsArray("scenarios");
            //            final JSONObject scenarioObject = scenarioArray.get(0).asObject();
            //
            //            scenario.setName(scenarioObject.getAsString("name").value());
            //
            //            final JSONObject bboxObject = scenarioObject.getAsObject("bbox");
            //            final Geodetic2D upper = new Geodetic2D(Angle.fromDegrees(bboxObject.getAsNumber("maxY").value()),
            //                     Angle.fromDegrees(bboxObject.getAsNumber("maxX").value()));
            //            final Geodetic2D lower = new Geodetic2D(Angle.fromDegrees(bboxObject.getAsNumber("minY").value()),
            //                     Angle.fromDegrees(bboxObject.getAsNumber("minX").value()));
            //            final Sector sector = new Sector(lower, upper);
            //            scenario.setSector(sector);
            //
            //            final JSONArray layerArrays = scenarioObject.getAsArray("layers");
            //
            //            final ArrayList<LayerData> layers = new ArrayList<LayerData>();
            //
            //            for (int i = 0; i < layerArrays.size(); i++) {
            //
            //
            //               final JSONObject layerObject = layerArrays.getAsObject(i);
            //
            //               final String typeLayer = layerObject.getAsString("type").value();
            //
            //               if (typeLayer.equals("osm")) {
            //                  //TODO:Include our params on scenario format
            //                  final OSM osm = new OSM();
            //                  osm.setType(type.osm);
            //                  layers.add(osm);
            //               }
            //               else if (typeLayer.equals("vectorial")) {
            //
            //                  final VectorLayerData vld = new VectorLayerData();
            //                  vld.setType(LayerData.type.vectorial);
            //                  vld.setName(layerObject.getAsString("name").value());
            //                  vld.setPath(layerObject.getAsString("path").value());
            //                  vld.setStylePath(layerObject.getAsString("stylePath").value());
            //                  layers.add(vld);
            //               }
            //
            //
            //            }
            //scenario.setLayers(layers);

            scenarioListener.onScenarioRead(scenario);


         }


         @Override
         public void onError(final URL url) {

         }


         @Override
         public void onCancel(final URL url) {

         }


         @Override
         public void onCanceledDownload(final URL url,
                                        final IByteBuffer buffer,
                                        final boolean expired) {

         }

      };

      downloader.requestBuffer( //
               new URL(scenarioPath, false), //
               0, //
               TimeInterval.zero(), //
               false, //
               listener, //
               false);
   }
}
