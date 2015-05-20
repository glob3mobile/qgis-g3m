

package com.globl3mobile.g3m.qgis.model;

import java.util.ArrayList;

import org.glob3.mobile.generated.Sector;


public class Scenario {

   private String               _name;
   private Sector               _sector     = Sector.fullSphere();
   private ArrayList<LayerData> _layers     = new ArrayList<LayerData>();
   private ArrayList<LayerData> _baseLayers = new ArrayList<LayerData>();


   public String getName() {
      return _name;
   }


   public void setName(final String name) {
      _name = name;
   }


   public Sector getSector() {
      return _sector;
   }


   public void setSector(final Sector sector) {
      _sector = sector;
   }


   public ArrayList<LayerData> getLayers() {
      return _layers;
   }


   public void setLayers(final ArrayList<LayerData> layers) {
      _layers = layers;
   }


   public String getDescription() {
      return "Name:" + _name + ",bbox" + _sector.description() + ",numLayers:" + _layers.size();
   }


   public ArrayList<LayerData> getBaseLayers() {
      return _baseLayers;
   }


   public void setBaseLayers(final ArrayList<LayerData> baseLayers) {
      _baseLayers = baseLayers;
   }
}
