using Windows.UI.Xaml.Controls;

namespace Student_Lookup.Dialogs
{
    public sealed partial class FileActivatedDialog : ContentDialog
    {
        public FileActivatedDialog()
        {
            InitializeComponent();
        }

        private void ContentDialog_SecondaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            Hide();
        }
    }
}
