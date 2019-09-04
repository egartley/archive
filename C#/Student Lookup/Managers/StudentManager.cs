using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Windows.Storage;

namespace Student_Lookup.Managers
{
    class StudentManager
    {
        public static ObservableCollection<Items.Student> fullDatabase = new ObservableCollection<Items.Student>();
        public static ObservableCollection<Items.Student> filteredDatabase = new ObservableCollection<Items.Student>();

        public static Items.Student selectedStudent;

        public static void PopulateDatabase(StorageFile file)
        {

        }
    }
}
