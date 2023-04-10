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
  var color = colorSelect.options[colorSelect.selectedIndex].value;
  var phoneNumber = document.getElementById("phoneNumber").value;
  var location = document.getElementById("location").value;
  var additionalInformation = document.getElementById("additional-information").value;
  var imageFiles = document.querySelector('input[type="file"][name="imageFiles"]').files;
  var terms = document.getElementById("acceptTerms").checked;

  var isValid = true;

  // Validate car make field
  if (selectedMake.trim() === '') {
    document.getElementById("car-make").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("car-make").classList.remove('is-invalid');
  }

  // Validate car model field
  if (selectedModel.trim() === '') {
    document.getElementById("car-model").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("car-model").classList.remove('is-invalid');
  }

  // Validate price field
  if (price.trim() === '' || isNaN(price) || parseInt(price) > 1000000) {
    document.getElementById("price").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("price").classList.remove('is-invalid');
  }

  // Validate month field
  if (month.trim() === '') {
    document.getElementById("month").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("month").classList.remove('is-invalid');
  }

  // Validate year field
  if (year.trim() === '') {
    document.getElementById("year").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("year").classList.remove('is-invalid');
  }

  // Validate engine type field
  if (selectedEngineType.trim() === '') {
    engineTypeSelect.classList.add('is-invalid');
    isValid = false;
  } else {
    engineTypeSelect.classList.remove('is-invalid');
  }

  // Validate engine power field
  if (enginePower.trim() === '' || !/^\d{1,5}$/.test(enginePower)) {
    document.getElementById("engine.power").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("engine.power").classList.remove('is-invalid');
  }

  // Validate euroStandard field
  if (euroStandard.trim() === '') {
    document.getElementById("engine.euroStandard").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("engine.euroStandard").classList.remove('is-invalid');
  }

  // Validate cubicCapacity field
  if (cubicCapacity.trim() === '' || !/^\d{1,4}$/.test(cubicCapacity)) {
    document.getElementById("engine.cubicCapacity").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("engine.cubicCapacity").classList.remove('is-invalid');
  }

  // Validate category field
  if (category.trim() === '') {
    document.getElementById("category.category").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("category.category").classList.remove('is-invalid');
  }

  // Validate gearbox type field
  if (gearBoxType.trim() === '') {
    document.getElementById("gearBox.gearBoxType").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("gearBox.gearBoxType").classList.remove('is-invalid');
  }

  // Validate mileage field
  var mileage = document.getElementById("mileage").value;
  if (mileage.trim() === '' || isNaN(mileage) || parseInt(mileage) > 250000) {
    document.getElementById("mileage").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("mileage").classList.remove('is-invalid');
  }

  // Validate color field
  if (color.trim() === '') {
    document.getElementById("color.paint").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("color.paint").classList.remove('is-invalid');
  }

  // Validate mobile field
    if (phoneNumber.trim() === '' || !isValidMobile(phoneNumber)) {
      document.getElementById("phoneNumber").classList.add('is-invalid');
      isValid = false;
    } else {
      document.getElementById("phoneNumber").classList.remove('is-invalid');
    }

  // Validate location field
  if (location.trim() === '') {
    document.getElementById("location").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("location").classList.remove('is-invalid');
  }

  // Validate additionalInformation field
  if (additionalInformation.trim() === '' || additionalInformation.length < 50) {
    document.getElementById("additional-information").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("additional-information").classList.remove('is-invalid');
  }

  // Validate terms checkbox
  if (!terms) {
    document.getElementById("acceptTerms").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("acceptTerms").classList.remove('is-invalid');
  }

  // Validate image upload field
  if (imageFiles.length < 1) {
    // No images selected, show error message
    document.querySelector('input[type="file"][name="imageFiles"]').classList.add('is-invalid');
    isValid = false;
  } else {
    // Images selected, remove error message
    document.querySelector('input[type="file"][name="imageFiles"]').classList.remove('is-invalid');
  }

  if (isValid) {
    // Submit the form programmatically
    document.getElementById("create-form").submit();

    // Clear form fields
    document.getElementById("create-form").reset();
  }
}

// Helper function to validate mobile number
  function isValidMobile(phoneNumber) {
    var regex = /^(088|089|087)\d{7}$/;
    return regex.test(phoneNumber);
  }
