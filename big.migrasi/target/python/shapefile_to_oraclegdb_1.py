import arcpy
import sys
import os.path

Schema_Type = "NO_TEST"
Subtype = ""
Field_Map = ""
folderName = r"c:\migrasi\connection"
namaSkema = str(sys.argv[1])
namaUnsur = str(sys.argv[2])
mapping = str(sys.argv[3])
path_ = str(sys.argv[4])
Target_sde = folderName + "\\"+ namaSkema +".sde" + "\\" + namaSkema + "." + namaUnsur

#SHAPE FILE DIGANTI DENGAN TABLE UNSUR SDE
Shapefile = folderName + "\\"+ namaSkema +".sde" + "\\" + namaSkema + "." + namaUnsur + "_TMP"
# Shapefile = "C:\\migrasi\\tmp\\" + path_ + "\\" + namaUnsur + ".shp"
# ShapefileOut = "C:\\migrasi\\tmp\\output\\" + namaUnsur + ".shp"
unsurs = mapping

dic = {}
unsurs_list = unsurs.split(";")

print "Mulai..."

fms = arcpy.FieldMappings()

# Create the required FieldMap and FieldMappings objects
fm_geom = arcpy.FieldMap()


result = arcpy.management.GetCount(Shapefile)
print(result)
if int(result[0]) > 0:
    for unsur in unsurs_list:
         if (unsur != 'OBJECTID' and path_ != 'output'):
            # ===================================================
            fm_unsur = arcpy.FieldMap()

            # Get the field names of vegetation type and diameter for both original
            # files
            in_unsur = unsur
            out_unsur = unsur
            # Add fields to their corresponding FieldMap objects
            print('in ' + in_unsur)
            print('in [0:10] ' + in_unsur[0:10])
            fm_unsur.addInputField(Shapefile, in_unsur[0:10])

            # Set the output field properties for both FieldMap objects
            print('out ' + in_unsur[0:10])
            out_unsur_f = fm_unsur.outputField
            out_unsur_f.name = out_unsur
            #
            fm_unsur.outputField = out_unsur_f

            # fms.addFieldMap(fm_geom)
            fms.addFieldMap(fm_unsur)

    arcpy.Append_management(Shapefile, Target_sde, Schema_Type, fms)


print "Delete temp data"
arcpy.Delete_management(Shapefile)
print "Done!!"