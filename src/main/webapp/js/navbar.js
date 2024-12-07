const dropdown = document.querySelector(".dropdown");
const menu = document.querySelector(".dropdown-menu");

dropdown.addEventListener("mouseenter", () => {
    menu.style.display = "block";
});

dropdown.addEventListener("mouseleave", () => {
    menu.style.display = "none";
});