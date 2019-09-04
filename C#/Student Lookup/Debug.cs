namespace Student_Lookup
{
    class Debug
    {

        public static void Out(object o)
        {
            System.Diagnostics.Debug.WriteLine(o);
        }

        public static void Out(object o, string tag)
        {
            Out(tag + " " + o);
        }

    }
}
