const dropdown = document.querySelector(".dropdown");
const menu = document.querySelector(".dropdown-menu");

dropdown.addEventListener("mouseenter", () => {
    menu.style.display = "block";
});

dropdown.addEventListener("mouseleave", () => {
    menu.style.display = "none";
});

const header = document.querySelector("header");

let prevScrollPos = window.scrollY;
window.addEventListener("scroll" , () => {
    let CurrentScroll = window.scrollY;
    if(CurrentScroll > prevScrollPos) {
        header.classList.add("fixed-top");
        header.style.transform = `translateY(-30%)`;
    }
    else {
        if (CurrentScroll <= 100){
            header.classList.remove("fixed-top");
        }
        header.style.transform = `translateY(0)`;
    }
    prevScrollPos = CurrentScroll;
});