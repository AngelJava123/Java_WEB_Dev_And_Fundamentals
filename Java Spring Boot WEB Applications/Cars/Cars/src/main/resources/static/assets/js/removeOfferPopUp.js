function confirmDelete() {
  // Show the popup container
  document.getElementById("popup-container").style.display = "block";

  // Prevent the link from being followed immediately
  return false;
}

function deleteOffer() {

  // Find the "REMOVE" link and get its href attribute
  var removeLink = document.querySelector('.remove-link');
  var deleteUrl = removeLink.getAttribute('href');

  // Follow the delete URL
  window.location.href = deleteUrl;

  // Hide the popup container
  document.getElementById("popup-container").style.display = "none";
}

function hidePopup() {
  // Hide the popup container
  document.getElementById("popup-container").style.display = "none";
}