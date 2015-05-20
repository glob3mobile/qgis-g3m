

package com.globl3mobile.g3m.qgis.model;

import org.glob3.mobile.generated.Sector;
import org.glob3.mobile.generated.TimeInterval;
import org.glob3.mobile.generated.URLTemplateLayer;


public class BaseLayers {


   public static URLTemplateLayer createBaseLayerByName(final String name) {


      switch (name) {
         case "CartoDB light":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "CartoDB light without labels":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/light_nolabels/{z}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "CartoDB dark":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "CartoDB dark without labels":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/dark_nolabels/{z}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Open topo map":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/dark_nolabels/{z}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         case "Stamen watercolor":
            return URLTemplateLayer.newMercator("http://s.basemaps.cartocdn.com/dark_nolabels/{z}/{x}/{y}.png", //URL
                     Sector.FULL_SPHERE,//SECTOR
                     false,//TRANSPARENCY
                     1, 18, TimeInterval.fromDays(30));
         default:
            break;
      }

      return null;
   }

}

//
///*CartoDB*/

//
///*Open topo map*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'Open topo map',
//        source: new ol.source.XYZ({
//                url: 'http://s.tile.opentopomap.org/{z}/{x}/{y}.png',
//                attributions: [new ol.Attribution({ html: ['Map data: &copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>, <a href="http://viewfinderpanoramas.org">SRTM</a> | Map style: &copy; <a href="https://opentopomap.org">OpenTopoMap</a> (<a href="https://creativecommons.org/licenses/by-sa/3.0/">CC-BY-SA</a>)']
//                })]
//        })
//})
//
//
///*Stamen watercolor*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'Stamen watercolor',
//        source: new ol.source.Stamen({layer: 'watercolor'})
//})
//
///*Stamen toner*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'Stamen toner',
//        source: new ol.source.Stamen({layer: 'toner'})
//})
//
///*Stamen toner lite*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'Stamen toner lite',
//        source: new ol.source.Stamen({layer: 'toner-lite'})
//})
//
///*OSM Mapnik*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'OSM Mapnik',
//        source: new ol.source.OSM()
//})
//
///*MapQuest roads*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'MapQuest roads',
//        source: new ol.source.MapQuest({layer: 'osm'})
//})
//
///*MapQuest aerial*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'MapQuest aerial',
//        source: new ol.source.MapQuest({layer: 'sat'})
//})
//
///*ESRI world topo map*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'ESRI world topo map',
//        source: new ol.source.XYZ({
//        attributions: [new ol.Attribution({ html:['Tiles &copy; <a href="http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer">ArcGIS</a>']})],
//        url: 'http://server.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer/tile/{z}/{y}/{x}'
//        })
//})
//
///*ESRI world street map*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'ESRI world street map',
//        source: new ol.source.XYZ({
//                attributions: [new ol.Attribution({ html:['Tiles &copy; <a href="http://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer">ArcGIS</a>']})],
//                url: 'http://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer/tile/{z}/{y}/{x}'
//        })
//})
//
///*ESRI DeLorme world map*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'ESRI DeLorme world map',
//        source: new ol.source.XYZ({
//                attributions: [new ol.Attribution({ html:['Tiles &copy; Esri &mdash; Copyright: &copy;2012 DeLorme']})],
//                url: 'http://server.arcgisonline.com/ArcGIS/rest/services/Specialty/DeLorme_World_Base_Map/MapServer/tile/{z}/{y}/{x}'
//        })
//})
//
///*ESRI world imagery*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'ESRI world imagery',
//        source: new ol.source.XYZ({
//                attributions: [new ol.Attribution({ html:['Tiles &copy; Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community']})],
//                url: 'http://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}'
//        })
//})
//
///*ESRI world terrain*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'ESRI world terrain',
//        source: new ol.source.XYZ({
//                attributions: [new ol.Attribution({ html:['Tiles &copy; Esri &mdash; Source: USGS, Esri, TANA, DeLorme, and NPS']})],
//                url: 'http://server.arcgisonline.com/ArcGIS/rest/services/World_Terrain_Base/MapServer/tile/{z}/{y}/{x}'
//        })
//})
//
//
///*ESRI world shaded relief*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'ESRI world shaded relief',
//        source: new ol.source.XYZ({
//                attributions: [new ol.Attribution({ html:['Tiles &copy; Esri &mdash; Source: Esri']})],
//                url: 'http://server.arcgisonline.com/ArcGIS/rest/services/World_Shaded_Relief/MapServer/tile/{z}/{y}/{x}'
//        })
//})
//
///*ESRI NatGeo world map*/
//new ol.layer.Tile({
//        type: 'base',
//        title: 'ESRI NatGeo world map',
//        source: new ol.source.XYZ({
//                attributions: [new ol.Attribution({ html:['Tiles &copy; Esri &mdash; National Geographic, Esri, DeLorme, NAVTEQ, UNEP-WCMC, USGS, NASA, ESA, METI, NRCAN, GEBCO, NOAA, iPC']})],
//                url: 'http://server.arcgisonline.com/ArcGIS/rest/services/NatGeo_World_Map/MapServer/tile/{z}/{y}/{x}'
//        })
//})
