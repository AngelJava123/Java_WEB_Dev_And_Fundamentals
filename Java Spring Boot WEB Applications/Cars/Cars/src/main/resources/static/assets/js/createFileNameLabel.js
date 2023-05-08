function createFileNameLabel(input) {
  const label = document.getElementById("file-name-label");
  if (input.files.length === 1) {
    label.textContent = input.files[0].name;
  } else if (input.files.length > 1) {
    label.textContent = input.files.length + " files selected";
  } else {
    label.textContent = "Choose Files";
  }
}
