function updateFileNameLabel(input) {
    var fileNameLabel = document.getElementById("file-name-label");
    fileNameLabel.innerText = input.files[0].name;
 }