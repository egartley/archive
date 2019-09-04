using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.Storage;
using Windows.Storage.Pickers;

namespace Student_Lookup.Dialogs
{
    public sealed partial class WelcomeDialog : ContentDialog
    {
        // debug for always showing the welcome dialog or not
        public static bool AlwaysShow = true;

        private string PreviousFileName = "FILENAME";

        public WelcomeDialog()
        {
            InitializeComponent();
        }

        private void WelcomeDialog_Loaded(object sender, RoutedEventArgs e)
        {
            SecondaryButtonText = Managers.StringManager.GetLocalizedString("WelcomeDialog_OkayButtonText");
        }

        private void OkayButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            // save district title
            if (DistrictTitleTextBox.Text.Length > 0)
            {
                string compositeKey = Managers.StringManager.GetLocalizedString("DistrictInformationCompositeKey");
                string nameKey = Managers.StringManager.GetLocalizedString("DistrictInformation_NameKey");
                ApplicationDataCompositeValue composite = Managers.SettingsManager.GetComposite(compositeKey);
                if (composite == null)
                {
                    System.Diagnostics.Debug.WriteLine("District information composite did not exist");
                    System.Diagnostics.Debug.WriteLine("Setting district title to \"" + DistrictTitleTextBox.Text.Trim() + "\"...");
                    // composite has not been set yet, therefore it needs to be set
                    Managers.SettingsManager.SetComposite(new ApplicationDataCompositeValue
                    {
                        [nameKey] = DistrictTitleTextBox.Text.Trim()
                    },
                    compositeKey);
                }
                else
                {
                    // already exists, update the name
                    composite[nameKey] = DistrictTitleTextBox.Text.Trim();
                    Managers.SettingsManager.SetComposite(composite, compositeKey);
                    System.Diagnostics.Debug.WriteLine("District information composite existed, set title to \"" + DistrictTitleTextBox.Text.Trim() + "\"");
                }
            }
            else
            {
                // no district title was entered, therefore don't change it
                // probably only while debugging/testing, not real world or production
                // because in real world, the welcome dialog (should) only get shown once
            }
            Hide();
        }

        private void SetDataFileValidity(Visibility valid, Visibility invalid)
        {
            ValidDataFileIconTextBlock.Visibility = valid;
            ValidDataFileTextBlock.Visibility = valid;
            InvalidDataFileIconTextBlock.Visibility = invalid;
            InvalidDataFileTextBlock.Visibility = invalid;
        }

        private void ShowValidDataFile()
        {
            SetDataFileValidity(Visibility.Visible, Visibility.Collapsed);
        }

        private void ShowInvalidDataFile()
        {
            SetDataFileValidity(Visibility.Collapsed, Visibility.Visible);
        }

        private void HideDataFileValidityStackPanel()
        {
            SetDataFileValidity(Visibility.Collapsed, Visibility.Collapsed);
        }

        private void ProcessDataFile(StorageFile file)
        {
            DataFileTextBox.Text = file.Path;

            // TODO: actually implement...
            // for now, just assume it's "valid" (whatever that means)
            ShowValidDataFile();

            ValidDataFileTextBlock.Text = ValidDataFileTextBlock.Text.Replace(PreviousFileName, file.Name);
            PreviousFileName = file.Name;
        }

        private async void BrowseButton_Click(object sender, RoutedEventArgs e)
        {
            var picker = new FileOpenPicker
            {
                ViewMode = PickerViewMode.List,
                SuggestedStartLocation = PickerLocationId.DocumentsLibrary,
                CommitButtonText = Managers.StringManager.GetLocalizedString("WelcomeDialog_BrowseFilePickerCommitButtonText")
            };
            picker.FileTypeFilter.Add(".studentdata"); // TODO: custom extension (file type association declaration)
            picker.FileTypeFilter.Add(".json");
            picker.FileTypeFilter.Add(".dat");
            picker.FileTypeFilter.Add(".data");
            picker.FileTypeFilter.Add(".txt");
            picker.FileTypeFilter.Add(".file");

            StorageFile file = await picker.PickSingleFileAsync();

            if (file != null)
            {
                ProcessDataFile(file);
            }
            else
            {
                // no file chosen
            }
        }
    }
}
