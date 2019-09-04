using Newtonsoft.Json;
using System.Collections.ObjectModel;
using System.Threading.Tasks;
using Windows.Storage;

namespace Student_Lookup.Items
{
    class StudentDataFile
    {

        public StorageFile File { get; set; }

        public ObservableCollection<Student> Students { get; set; }

        public StudentDataFile(StorageFile file)
        {
            File = file;
            Students = null;
        }

        public async Task Read()
        {
            // TODO: either memory management, or cache remembered students
            string rawjson = await Managers.FileManager.GetFileContents(File);
            if (rawjson.Length > 0)
                Students = JsonConvert.DeserializeObject<ObservableCollection<Student>>(rawjson);
            else
                Students = new ObservableCollection<Student>();
        }

        public async Task Write()
        {
            await Managers.FileManager.WriteToFile(File, JsonConvert.SerializeObject(Students));
        }

    }
}
