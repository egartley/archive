using Student_Lookup.Managers;
using System;
using Windows.Storage;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace Student_Lookup.Pages
{
    public sealed partial class Home : Page
    {
        public static bool FirstLoad = true;

        public Home()
        {
            InitializeComponent();
        }

        private async void Page_Loaded(object sender, RoutedEventArgs e)
        {
            // check if this is the first time the home page has been loaded
            if (FirstLoad == true)
            {
                // first time home page has been loaded, check if the welcome dialog has been shown or not

                // store localized strings temp
                string didShowWelcomeDialogCompositeKey = StringManager.GetLocalizedString("DidShowWelcomeDialogCompositeKey");
                string didShowWelcomeDialogValueKey = StringManager.GetLocalizedString("DidShowWelcomeDialogCompositeKeyValueKey");

                // get the composite
                ApplicationDataCompositeValue welcomeDialogComposite = SettingsManager.GetComposite(didShowWelcomeDialogCompositeKey);

                bool alreadyShown = !Dialogs.WelcomeDialog.AlwaysShow;

                if (welcomeDialogComposite == null)
                {
                    // not previously set, so set it
                    SettingsManager.SetComposite(new ApplicationDataCompositeValue{[didShowWelcomeDialogValueKey] = true}, didShowWelcomeDialogCompositeKey);
                }
                else
                {
                    // composite existed
                    if (Dialogs.WelcomeDialog.AlwaysShow == false)
                    {
                        // AlwaysShow was false, so just get the composite value
                        alreadyShown = (bool)welcomeDialogComposite[StringManager.GetLocalizedString(didShowWelcomeDialogValueKey)];
                    }
                    // else
                    // AlwaysShow was true, therefore show the welcome dialog regardless of the composite value
                }

                if (alreadyShown == false)
                {
                    // dialog has either not been shown, or AlwaysShow was true
                    // show dialog
                    await new Dialogs.WelcomeDialog().ShowAsync();
                }

                // prevent this from running again if the home page is ever loaded again
                FirstLoad = false;
            }

            // load list items
            // TODO
        }

        private void StudentResultsListView_ItemClick(object sender, ItemClickEventArgs e)
        {
            // display student attributes (dialog or detail pane?)
        }

        private void SearchBox_QuerySubmitted(AutoSuggestBox sender, AutoSuggestBoxQuerySubmittedEventArgs args)
        {
            // enter pressed or suggestion chosen
        }

        private void SearchBox_SuggestionChosen(AutoSuggestBox sender, AutoSuggestBoxSuggestionChosenEventArgs args)
        {
            // suggestions was chosen, so "submit" it
        }

        private void SearchBox_Loaded(object sender, RoutedEventArgs e)
        {
            // build suggestions
        }

        private void SearchBox_TextChanged(AutoSuggestBox sender, AutoSuggestBoxTextChangedEventArgs args)
        {
            // search suggestions with updated query
        }
    }
}
