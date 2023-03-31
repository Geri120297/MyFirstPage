if(!location.href.includes("@")){
    accessDenied()
}
$.ajax({
    url: "http://localhost:8080/visitor/access/" + email,
    type: "GET",
    cors: true,
    success: function (access){
        console.log(access)
        if(access === true){
            console.log("Zugriff")
        }else{
            accessDenied()
    }
        },
    error: function (e) {
        console.log(e)
    }
})

function accessDenied(){
    console.log("kein Zugriff")
    const accessDenied = $(`#accessDenied`)
    accessDenied.empty()
    const button = $(`<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#accessDenied" hidden>
</button>
`)
    const modalAlert = $(`
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Ihre Sitzung ist abgelaufen</h1>
      </div>
      <div class="modal-body">
        Sie müssen sich neu anmelden
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="goBackToLogin()">OK</button>
      </div>
    </div>
  </div>
</div>


`)
    accessDenied.append(button)
    accessDenied.append(modalAlert)
    button.click()
}

function goBackToLogin(){
    location.href = "Authentication.html"
}
const content = $(`#content`)
const addPost = $(`#addContent`)
if(location.href.includes("Main.html")) {
    loadContent()
}

function loadContent(){

    $.ajax({
        url: "http://localhost:8080/postsMain",
        type: "GET",
        cors: true,
        success: function (e){
            content.empty()
            addPost.empty()
            if(email === "admin@email.at"){
                const button = $(`<button type="button" class="btn btn-info mt-5 ms-5 col-2" onclick="addContent()">Post hinzufügen</button>
`)
                addPost.append(button)
            }
            for(let p of e){
                const posts = $(`<div class="ms-5 mt-3 me-5 col-12 row" id="content${p.id}"></div>`)
                if(email === "admin@email.at"){
                    posts.append(`<button type="button" class="btn-close mt-5" onclick="deletePost(${p.id})" </button>`)
                    posts.append($(`<h1>${p.title}</h1><p>${p.text}</p><hr class="col-10">`))
                    content.append(posts)

                }else{
                    posts.append($(`<h1>${p.title}</h1><p>${p.text}</p><hr class="col-10">`))
                    content.append(posts)
                }
            }
        },
        error: function () {
        console.log("Fehler")
        }
    })
}
function deletePost(id){
    $.ajax({
        url: "http://localhost:8080/postsMain/" + id,
        type: "DELETE",
        cors: true,
        success: function (){
            console.log("erfolgreich gelöscht")
            loadContent()
        },
        error: function (){
            console.log("hat nicht funktioniert")
        }
    })
}
function addContent(){
    addPost.empty()
    const addForm = $(`<div class="mb-3 ms-5 me-5 mt-5">
  <label for="exampleFormControlInput1" class="form-label">Titel</label>
  <input type="text" class="form-control" id="contentTitel">
</div>
<div class="mb-3 ms-5 me-5">
  <label for="contentTitel" class="form-label"></label>
  <textarea class="form-control" id="contentText" rows="3"></textarea>
</div>`)
    const submit = $(`<div class="col-auto">
    <button type="button" class="btn btn-primary ms-5 mb-3" onclick="addContentToServer()">Hinzufügen</button>
  </div>
`)
    content.empty()
    addPost.append(addForm)
    addPost.append(submit)

}
function addContentToServer(){
    const contentJson = {}
    const title = document.getElementById(`contentTitel`).value
    const text = document.getElementById(`contentText`).value
    contentJson["title"] = title.toString()
    contentJson["text"] = text.toString()
    const content = JSON.stringify(contentJson)
    console.log(content)
    $.ajax({
        url: "http://localhost:8080/postsMain/create",
        type: "POST",
        contentType: "application/json",
        cors: true,
        data: content,
        success: function() {
            console.log("Hat funktioniert")
            loadContent()
        },
        error: function() {
            console.log("Hat nicht funktioniert")
        }
    })
}