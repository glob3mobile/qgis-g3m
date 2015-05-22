

package com.glob3mobile.g3m.qgis.model;

public class LayerData {
   private String _name;
   private type   _type;

   public static enum type {
      templateLayer,
      vectorial,
      wms
   }


   public String getName() {
      return _name;
   }


   public void setName(final String name) {
      _name = name;
   }


   public type getType() {
      return _type;
   }


   public void setType(final type type) {
      _type = type;
   }
}
