import arcpy
import os.path

Schema_Type = "TEST"
Subtype = ""
Field_Map = ""
folderName = r"c:\connectionFiles"


def createSdeConnection(connectionName, username, password):
    # Set variables
    fileName = connectionName + ".sde"
    serverName = "192.168.3.102"  # HOST
    instance = "dbpprt"  # oracle SID/service name
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


conPath = folderName + "\\" + "IGD5K" + ".sde"
if not os.path.exists(conPath):
    print("creating sde connection")
    createSdeConnection("IGD5K", "IGD5K", "IGD5K")
    print("SDE connection path " + conPath)
