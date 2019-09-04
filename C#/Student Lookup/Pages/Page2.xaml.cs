using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace Student_Lookup.Pages
{
    public sealed partial class Page2 : Page
    {
        public Page2()
        {
            InitializeComponent();
        }

        private void Page_Loaded(object sender, RoutedEventArgs e)
        {
            string districtName = (string)(Managers.SettingsManager.GetComposite(Managers.StringManager.GetLocalizedString("DistrictInformationCompositeKey"))[Managers.StringManager.GetLocalizedString("DistrictInformation_NameKey")]);
            if (districtName != null)
            {
                SchoolNameTextBlock.Text += districtName;
            }
        }
    }
}
