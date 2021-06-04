"use strict";

const $americano = document.querySelector(".americano");
const $latte = document.querySelector(".latte");
const $menu1 = document.querySelector(".menu1");
const $menu2 = document.querySelector(".menu2");

$americano.addEventListener("click", (event) => {
  $americano.classList.add("hide");
  $latte.classList.remove("hide");
});

$latte.addEventListener("click", (event) => {
  $latte.classList.add("hide");
  $americano.classList.remove("hide");
});

$americano.onclick = handleClick;

function handleClick() {
  console.log("ame");
}
