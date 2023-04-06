function submitForm() {
  var makeSelect = document.getElementById("car-make");
  var selectedMake = makeSelect.options[makeSelect.selectedIndex].value;
  var modelSelect = document.getElementById("car-model");
  var selectedModel = modelSelect.options[modelSelect.selectedIndex].value;
  var price = document.getElementById("price").value;
  var month = document.getElementById("month").value;
  var year = document.getElementById("year").value;
  var engineTypeSelect = document.getElementById("engine.engineType");
  var selectedEngineType = engineTypeSelect.options[engineTypeSelect.selectedIndex].value;
  var enginePower = document.getElementById("engine.power").value;
  var euroStandardSelect = document.getElementById("engine.euroStandard");
  var euroStandard = euroStandardSelect.options[euroStandardSelect.selectedIndex].value;
  var cubicCapacity = document.getElementById("engine.cubicCapacity").value;
  var categorySelect = document.getElementById("category.category");
  var category = categorySelect.options[categorySelect.selectedIndex].value;
  var gearBoxTypeSelect = document.getElementById("gearBox.gearBoxType");
  var gearBoxType = gearBoxTypeSelect.options[gearBoxTypeSelect.selectedIndex].value;
  var mileage = document.getElementById("mileage").value;
  var colorSelect = document.getElementById("color.paint");
  var phoneNumber = document.getElementById("phoneNumber").value;
  var location = document.getElementById("location").value;
  var color = colorSelect.options[colorSelect.selectedIndex].value;
  var additionalInformation = document.getElementById("additional-information").value;
  var terms = document.getElementById("acceptTerms").checked;

  var popupContainer = document.getElementById("popup-container");

  // Check if all fields are populated
  if (selectedMake && selectedModel && !isNaN(price) && month && year && selectedEngineType
      && !isNaN(enginePower) && euroStandard && !isNaN(cubicCapacity) && category && gearBoxType
      && !isNaN(mileage) && color && phoneNumber && location && additionalInformation && terms) {

    // Check if file is uploaded
    var fileInput = document.querySelector('input[type="file"]');
    if (!fileInput || fileInput.files.length === 0) {
      // Show error message in popup container
      popupContainer.innerText = "Please upload at least one image!";
      popupContainer.style.display = "block";
    } else {
      // Submit the form programmatically
      document.getElementById("create-form").submit();
      // Show success message in popup container
      popupContainer.innerText = "Your offer has been submitted successfully!";
      popupContainer.style.display = "block";
      // Clear form fields
      document.getElementById("create-form").reset();
    }
  } else {
    // Show error message in popup container
    popupContainer.innerText = "Please fill in all fields with valid information and accept the terms before submitting!";
    popupContainer.style.display = "block";
  }

  // Hide popup after a few seconds
  setTimeout(function() {
    popupContainer.style.display = "none";
  }, 5000);
}
