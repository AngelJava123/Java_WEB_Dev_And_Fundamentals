var slider = document.querySelector('.slider');
var sliderItems = document.querySelectorAll('.slider-item');
var sliderItemWidth = sliderItems[0].clientWidth;
var sliderIndex = 0;

var prevArrow = document.querySelector('.slider-arrow-prev');
var nextArrow = document.querySelector('.slider-arrow-next');

prevArrow.addEventListener('click', function() {
  sliderIndex--;
  if (sliderIndex < 0) {
    sliderIndex = sliderItems.length - 1;
  }
  updateSlider();
});

nextArrow.addEventListener('click', function() {
  sliderIndex++;
  if (sliderIndex >= sliderItems.length) {
    sliderIndex = 0;
  }
  updateSlider();
});

function updateSlider() {
  var translateX = -sliderIndex * sliderItemWidth;
  slider.style.transform = 'translateX(' + translateX + 'px)';
}

updateSlider();