$(document).ready(function() {
  // Hide all car models initially
  $('#car-model option').hide();

  // When car make is selected, show only the models for that make
  $('#car-make').change(function() {
    var selectedMake = $(this).val();
    $('#car-model option').hide();
    $('#car-model option[data-make="' + selectedMake + '"]').show();
    $('#car-model').val('');
  });
});