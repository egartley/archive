using System;
using System.Collections.ObjectModel;

namespace Student_Lookup.Items
{
    class Student
    {
        public StudentAttribute Nickname = new StudentAttribute(false, typeof(string));

        public StudentAttribute FirstName = new StudentAttribute(true, typeof(string));

        public StudentAttribute MiddleName = new StudentAttribute(false, typeof(string));

        public StudentAttribute LastName = new StudentAttribute(true, typeof(string));

        public StudentAttribute DateOfBirth = new StudentAttribute(true, typeof(string));

        public StudentAttribute HasDisability = new StudentAttribute(true, typeof(bool));

        public StudentAttribute GradeLevel = new StudentAttribute(true, typeof(int));

        public ObservableCollection<StudentAttribute> CustomAttributes = new ObservableCollection<StudentAttribute>();

        public string DisplayName()
        {
            if (Nickname.AsString().Length == 0)
            {
                return FirstName.AsString() + " " + LastName.AsString();
            }
            else
            {
                return FirstName.AsString() + " \"" + Nickname.AsString() + "\"" + LastName.AsString();
            }
        }

        public int CurrentAge()
        {
            // **accurate within 24 hours and 1 minute**

            string birthday = DateOfBirth.AsString();
            if (birthday == "")
            {
                return -1;
            }

            // TODO: make it possible for other formats, such as unix time or MM/DD/YYYY
            // for now, this assumes DOB is inputted as MM-DD-YYYY
            string yr = birthday.Substring(birthday.IndexOf("-") + 1);
            yr = yr.Substring(yr.IndexOf("-") + 1);

            int year, end = int.Parse(yr);
            if (end < 20)
            {
                // year >= 2000
                string r;
                if (end >= 10)
                {
                    // ex. "12"
                    r = end.ToString();
                }
                else
                {
                    // year is [2000, 2009]
                    // ex. "00"
                    r = "0" + end;
                }
                // ex. 2001
                year = int.Parse("20" + r);
            }
            else
            {
                // year < 2000
                year = int.Parse("19" + end);
            }
            int age = DateTime.Today.Year - year;
            if (DateTime.Parse(birthday) > DateTime.Today.AddYears(age * -1))
            {
                // DOB has yet to occur this year, therefore subtract 1
                age--;
            }
            return age;
        }
    }
}
