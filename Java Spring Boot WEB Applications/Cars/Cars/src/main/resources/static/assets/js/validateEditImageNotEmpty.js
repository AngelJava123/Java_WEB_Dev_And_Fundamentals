function validateForm() {
  var fileInput = document.querySelector('input[type="file"]');
  if (!fileInput || !fileInput.files || fileInput.files.length === 0) {
    document.getElementById("error-message").style.display = "block";
    return false;
  }
  return true;
}