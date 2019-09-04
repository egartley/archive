namespace Student_Lookup.Items
{
    class StudentListItem
    {

        public StudentListItem(Student s)
        {
            Student = s;
        }

        public Student Student { get; set; }

        public string DisplayText { get { return Student.DisplayName(); } }

        public string DisplaySubText { get { return Student.PrettyGradeLevel() + " grade"; } }

    }
}
