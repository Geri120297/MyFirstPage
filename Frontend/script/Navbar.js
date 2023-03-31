const url = document.location.href;
const index = url.indexOf("?");
const email = url.substring(index + 1);
const navbar = $('#navbar')
const inhalt = $(`<div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;"><li class="nav-item ms-5">
                    <a class="nav-link active" aria-current="page" href="Main.html?${email}">Home</a>
                </li><li class="nav-item ms-5">
                    <a class="nav-link active" href="#">Bewerbung</a>
                </li><li class="nav-item active ms-5">
                    <a class="nav-link active" href="#">Kontakt</a>
                </li></ul></div></div>`)
navbar.append(inhalt)