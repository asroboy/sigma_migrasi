# -*- coding: utf-8 -*-
# ---------------------------------------------------------------------------
# MenghitungIndex.py
# Created on: 2018-05-31 22:00:25.00000
#   (generated by ArcGIS/ModelBuilder)
# Usage: SelectionTools <Input_Layer> <Layer_Indeks> <INDEKS_SELECTION> 
# Description: 
# ---------------------------------------------------------------------------

# Set the necessary product code
# import arcinfo


# Import arcpy module
import arcpy

print('Mulai menghitung index')
path_data = "C:\migrasi\\tmp\produksi\\"
path_index = "C:\migrasi\\tmp\ketersediaan_index\\"
path_index_global = "C:\migrasi\ketersediaan_index\\"
# Script arguments
NamaUnsur = arcpy.GetParameterAsText(0)
Input_Layer = path_data + NamaUnsur + ".shp"
if NamaUnsur == '#' or not NamaUnsur:
    Input_Layer = ""  # provide a default value if unspecified
    # Input_Layer = "ADMINISTRASI_AR" # provide a default value if unspecified

SKALA = arcpy.GetParameterAsText(1)
Layer_Indeks = path_index_global + 'INDEKS_' + SKALA + "_REV.shp"
if SKALA == '#' or not SKALA:
    Layer_Indeks = ""  # provide a default value if unspecified
    # Layer_Indeks = "INDEKS_5K_REV" # provide a default value if unspecified

IDX_SHP = arcpy.GetParameterAsText(2)
INDEKS_SELECTION = path_index + IDX_SHP + ".shp"
if IDX_SHP == '#' or not IDX_SHP:
    INDEKS_SELECTION = path_index + "ketersediaan_index.shp"  # provide a default value if unspecified
    # INDEKS_SELECTION = "C:\\Users\\ansaf\\Documents\\ArcGIS\\Default.gdb\\INDEKS_SELECTION" # provide a default value if unspecified

# Local variables:
FeatureVerti1 = path_index + NamaUnsur + "_CENTEROID.shp"
Layer_Point = FeatureVerti1
Hasil_Selection = Layer_Point


print('Mengambil point vertex')
# Process: Feature Vertices To Points
arcpy.FeatureVerticesToPoints_management(Input_Layer, FeatureVerti1, "ALL")

# Process: Make Feature Layer
arcpy.MakeFeatureLayer_management(FeatureVerti1, Layer_Point, "", "",
                                  "OBJECTID_1 OBJECTID_1 VISIBLE NONE;Shape Shape VISIBLE NONE;WADMKC WADMKC VISIBLE NONE;KDBBPS KDBBPS VISIBLE NONE;WADMKD WADMKD VISIBLE NONE;KDEPUM KDEPUM VISIBLE NONE;KDCPUM KDCPUM VISIBLE NONE;FCODE FCODE VISIBLE NONE;WIADKK WIADKK VISIBLE NONE;SHAPE_AREA SHAPE_AREA VISIBLE NONE;NAMOBJ NAMOBJ VISIBLE NONE;OBJECTID OBJECTID VISIBLE NONE;KDPBPS KDPBPS VISIBLE NONE;SHAPE_LENG SHAPE_LENG VISIBLE NONE;WIADKC WIADKC VISIBLE NONE;WIADKD WIADKD VISIBLE NONE;WADMKK WADMKK VISIBLE NONE;REMARK REMARK VISIBLE NONE;KDCBPS KDCBPS VISIBLE NONE;KDEBPS KDEBPS VISIBLE NONE;KDPKAB KDPKAB VISIBLE NONE;SRS_ID SRS_ID VISIBLE NONE;KDPPUM KDPPUM VISIBLE NONE;TIPADM TIPADM VISIBLE NONE;WIADPR WIADPR VISIBLE NONE;LUASWH LUASWH VISIBLE NONE;LCODE LCODE VISIBLE NONE;METADATA METADATA VISIBLE NONE;WADMPR WADMPR VISIBLE NONE;ORIG_FID ORIG_FID VISIBLE NONE")
print('Mengambil point vertex selesai')

arcpy.MakeFeatureLayer_management(Layer_Indeks, "layer_index")
arcpy.MakeFeatureLayer_management(Layer_Point, "Layer_Point")
print "layer_index dibuat."
print "mohon tunggu..."

# Process: Select Layer By Location
arcpy.SelectLayerByLocation_management("layer_index", "CONTAINS", "Layer_Point", "0.05 Meters", "NEW_SELECTION")

# Process: Copy Features
arcpy.CopyFeatures_management("layer_index", INDEKS_SELECTION, "", "0", "0", "0")
print "Selsai menghitung index."


