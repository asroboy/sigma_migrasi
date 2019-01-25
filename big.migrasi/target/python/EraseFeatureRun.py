# -*- coding: utf-8 -*-
# ---------------------------------------------------------------------------
# EraseFeatureRun.py
# Created on: 2018-04-06 19:44:57.00000
#   (generated by ArcGIS/ModelBuilder)
# Description:
# ---------------------------------------------------------------------------

# Set the necessary product code
# import arcinfo


# Import arcpy module
import arcpy
import sys

folderConnectionName = r"c:\migrasi\connection"
folderRoot = r"c:\migrasi\tmp"
namaUnsur = str(sys.argv[1])
skemaName = str(sys.argv[2])

# Local variables:
# C:\Users\Ridho\AppData\Roaming\Esri\Desktop10.2\ArcCatalog\MIGRASISDE@LOCAL.sde\IGD1000K.ADMINISTRASI_AR
# InputFeature = "C:\Users\Ridho\Documents\Kerjaan\Virtua\Migrasi\EraseFeature\\FiturYangAkanDihapus.shp"
# InputFeature = folderRoot + "\publikasi\\" + namaUnsur + ".shp"
InputFeature = folderConnectionName + "\\" + skemaName + ".sde\\"+  skemaName + "."+ namaUnsur
EraseFeature = folderRoot + "\\ketersediaan_index\\ketersediaan_index.shp"
arcpy.MakeFeatureLayer_management(InputFeature, "InputFeature_Edit")
arcpy.MakeFeatureLayer_management(EraseFeature, "EraseFeature_Eraser")

print('input feature ' + InputFeature)
print('erase feature ' + EraseFeature)
# OutputFeature = folderRoot + "\output\\" + namaUnsur
OutputFeature = folderConnectionName + "\\" + skemaName + ".sde\\" +  skemaName + "." + namaUnsur + "_TMP"
print('output feature ' + OutputFeature)

# Process: Erase
tolerance = ""
if "AR" in namaUnsur:
    tolerance = "0.09 Meters"
else :
    tolerance = "0.001 Meters"

arcpy.Erase_analysis("InputFeature_Edit", "EraseFeature_Eraser", OutputFeature, tolerance)
