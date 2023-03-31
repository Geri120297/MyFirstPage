function tryAuthentication(email){
    $.ajax({
        url: "http://localhost:8080/visitor/" + email,
        type: "GET",
        cors: true,
        success : function (user){
            console.log(user)
            if(user.email === email && user.access){
                goTo(user);
            }else{
                const errDiv = $("#error")
                errDiv.empty()
                const text = $(`<p>Diese Email ${email} ist nicht hinterlegt, Sie sind nicht berechtigt !</p>`)
                errDiv.append(text)
            }
        },
        error: error => {
            console.log("Hat nicht geklappt");

        }

    })
}
function goTo(user) {
    location.href = "Main.html?" + user.email
}




