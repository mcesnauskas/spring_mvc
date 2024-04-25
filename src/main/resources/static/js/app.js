<!--    const btnAlert = document.getElementById("btnAlertId");-->
<!--    btnAlert.addEventListener(-->
<!--    "click", ()=>{-->
<!--        alert("Alert message");-->
<!--    }-->
<!--);-->

    function showAlert(){
        alert("Alert message");
    }

    function showMessageAlert(message){
        alert("Received message: " + message);
    }

    function displaySelectedHobby(){
        let selectHobby = document.getElementById("SelectHobbyId");
        let selectedText = selectHobby.options[selectHobby.selectedIndex].text;

        let paragraphHobby = document.getElementById("displayHobbyId");
        paragraphHobby.innerText = selectedText;
    }

    function displaySelectedHobby02(){
            let selectHobby = document.getElementById("SelectHobbyId02");
            let selectedText = selectHobby.options[selectHobby.selectedIndex].text;

            let paragraphHobby = document.getElementById("displayHobbyId02");
            paragraphHobby.innerText = selectedText;
        }

    function displaySelectedHobby03(){
                let selectHobby = document.getElementById("SelectHobbyId03");
                let selectedValue = selectHobby.options[selectHobby.selectedIndex].value;

                let paragraphHobby = document.getElementById("displayHobbyId03");
                paragraphHobby.innerText = selectedValue;
         }

    window.onload = displaySelectedHobby02();
    window.onload = displaySelectedHobby03();

