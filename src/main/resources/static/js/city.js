

   function displaySelectedCity() {
            let selectCity = document.getElementById("selectCityId");
            let selectedCity = selectCity.options[selectCity.selectedIndex].text;

            let paragraphCity = document.getElementById("displayCityId");
            paragraphCity.innerText = selectedCity;
        }

    window.onload = displaySelectedCity();

