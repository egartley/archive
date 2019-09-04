using System;
using System.Threading.Tasks;
using Windows.Storage;

namespace Student_Lookup
{
    class DataBroker
    {

        public static bool IsStudentDataInitialized = false;
        public static bool IsStudentDataChunked = false;

        public static string StudentDataFolderName = "students";
        public static string StudentDataSingleChunkedFileName = "chunk00.student-data";

        public static Items.StudentDataFile CurrentStudentDataFile;
        public static StorageFolder StudentDataFolder = null;

        public static async Task InitializeStudentData()
        {
            try
            {
                if (!IsStudentDataInitialized)
                {
                    Debug.Out("1");
                    if (await Managers.FileManager.GetExists(StudentDataFolderName))
                        StudentDataFolder = await Managers.FileManager.LocalFolder.GetFolderAsync(StudentDataFolderName);
                    Debug.Out("2");
                    if (StudentDataFolder == null)
                    {
                        Debug.Out("2a");
                        await Managers.FileManager.LocalFolder.CreateFolderAsync(StudentDataFolderName);
                        Debug.Out("2b");
                        StudentDataFolder = await Managers.FileManager.LocalFolder.GetFolderAsync(StudentDataFolderName);
                    }
                    Debug.Out("3");
                    // TODO: chunk data
                    IsStudentDataChunked = (await StudentDataFolder.GetItemsAsync()).Count >= 1;
                    Debug.Out("4");
                    if (await Managers.FileManager.GetExists(StudentDataFolder, StudentDataSingleChunkedFileName))
                    {
                        Debug.Out("5");
                        CurrentStudentDataFile = new Items.StudentDataFile(await StudentDataFolder.GetFileAsync(StudentDataSingleChunkedFileName));
                    }
                    else
                    {
                        Debug.Out("5");
                        CurrentStudentDataFile = new Items.StudentDataFile(await StudentDataFolder.CreateFileAsync(StudentDataSingleChunkedFileName));
                    }
                    Debug.Out("6");
                    await CurrentStudentDataFile.Read();
                }

                IsStudentDataInitialized = true;
            }
            catch (Exception e)
            {
                Debug.Out(e.Source + "\n" + e.StackTrace + "\n" + e.Message);
            }
        }

    }
}
