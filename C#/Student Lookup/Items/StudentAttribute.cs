namespace Student_Lookup.Items
{
    class StudentAttribute
    {
        public bool Required { get; set; }

        public object Value { get; set; }

        public System.Type Type { get; set; }

        public StudentAttribute(bool required, System.Type type)
        {
            Required = required;
            Type = type;
        }

        public string AsString()
        {
            return Value.ToString();
        }

        public int AsInt()
        {
            if (int.TryParse(AsString(), out int r))
            {
                return r;
            }
            else
            {
                return 0;
            }
        }

        public double AsDouble()
        {
            if (double.TryParse(AsString(), out double r))
            {
                return r;
            }
            else
            {
                return 0.0;
            }
        }

        public float AsFloat()
        {
            if (float.TryParse(AsString(), out float r))
            {
                return r;
            }
            else
            {
                return 0;
            }
        }

        public long AsLong()
        {
            if (long.TryParse(AsString(), out long r))
            {
                return r;
            }
            else
            {
                return 0L;
            }
        }

        public byte AsByte()
        {
            if (byte.TryParse(AsString(), out byte r))
            {
                return r;
            }
            else
            {
                return 0;
            }
        }

        public bool AsBool()
        {
            if (bool.TryParse(AsString(), out bool r))
            {
                return r;
            }
            else
            {
                return false;
            }
        }
    }
}
