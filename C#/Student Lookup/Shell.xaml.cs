using System.Linq;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;

namespace Student_Lookup
{
    public sealed partial class Shell : Page
    {
        private string CurrentPageTag = "HasNotNavigatedYet";

        public Shell()
        {
            InitializeComponent();
        }

        private void ShellFrame_Navigated(object sender, NavigationEventArgs e)
        {

        }

        private void NavigationView_ItemInvoked(NavigationView sender, NavigationViewItemInvokedEventArgs args)
        {
            if (args.IsSettingsInvoked)
            {
                // ShellFrame.Navigate(typeof(SettingsPage));
            }
            else
            {
                var item = sender.MenuItems.OfType<NavigationViewItem>().First(x => (string)x.Content == (string)args.InvokedItem) as NavigationViewItem;
                HamburgerMenu_Navigate(item);
                // set CurrentPageTag to prevent navigating to the same page
                CurrentPageTag = item.Tag.ToString();
            }
        }

        private void HamburgerMenu_Navigate(NavigationViewItem item)
        {
            if (item.Tag.ToString().Equals(CurrentPageTag))
            {
                // ex. at Home, tried to navigate to Home again
                // System.Diagnostics.Debug.WriteLine("Tried to navigate to the current page again (given: " + item.Tag.ToString() + ", current: " + CurrentPageTag + ")");
                return;
            }

            switch (item.Tag)
            {
                case "home":
                    ShellFrame.Navigate(typeof(Pages.Home));
                    break;

                case "page2":
                    ShellFrame.Navigate(typeof(Pages.Page2));
                    break;
            }

        }

        private void NavigationView_Loaded(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            foreach (NavigationViewItemBase item in HamburgerMenu.MenuItems)
            {
                if (item is NavigationViewItem && item.Tag.ToString() == "home")
                {
                    HamburgerMenu.SelectedItem = item;
                    HamburgerMenu_Navigate(item as NavigationViewItem);
                    break;
                }
            }
        }
    }
}
