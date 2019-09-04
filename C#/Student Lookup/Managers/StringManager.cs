namespace Student_Lookup.Managers
{
    class StringManager
    {

        /// <summary>
        /// Returns the localized string at the given key
        /// </summary>
        /// <param name="key">Key of the string to get</param>
        /// <returns>Localized version of the string with the provided key</returns>
        public static string GetLocalizedString(string key) => Windows.ApplicationModel.Resources.ResourceLoader.GetForCurrentView().GetString(key);

    }
}
