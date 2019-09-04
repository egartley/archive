using Windows.Storage;

namespace Student_Lookup.Managers
{
    class SettingsManager
    {

        private static ApplicationDataContainer LocalSettings = ApplicationData.Current.LocalSettings;

        public static void SetComposite(ApplicationDataCompositeValue composite, string key) => LocalSettings.Values[key] = composite;

        public static ApplicationDataCompositeValue GetComposite(string key) => (ApplicationDataCompositeValue)LocalSettings.Values[key];
    }
}