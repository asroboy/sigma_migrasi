import arcpy
import sys
import os.path
from arcpy import env

Schema_Type = "TEST"
Subtype = ""
Field_Map = ""
folderName = r"c:\migrasi\connection"


def createSdeConnection(connectionName, username, password):
    # Set variables
    fileName = connectionName + ".sde"
    serverName = str(sys.argv[1])  # HOST
    instance = str(sys.argv[2])  # oracle SID/service name
    authType = "DATABASE_AUTH"
    saveUserInfo = "SAVE_USERNAME"

    arcpy.CreateDatabaseConnection_management(folderName,
                                              fileName,
                                              "ORACLE",
                                              serverName + "/" + instance,
                                              authType,
                                              username,
                                              password,
                                              saveUserInfo)


skemaName = str(sys.argv[3])
conPath = folderName + "\\" + skemaName + ".sde"
if not os.path.exists(conPath):
    print("creating sde connection")
    createSdeConnection(skemaName, skemaName, skemaName)
    print("SDE connection path " + conPath)
