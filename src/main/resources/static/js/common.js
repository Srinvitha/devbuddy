window.addEventListener("load",()=>{

    const loader=document.getElementById("loader");

    setTimeout(()=>{

        loader.classList.add("loader-hidden");

    },800);

    const elements=document.querySelectorAll(

        ".card,.feature,.badges span"

    );

    elements.forEach((element,index)=>{

        element.classList.add("fade-up");

        setTimeout(()=>{

            element.classList.add("show");

        },index*120);

    });

});

const glow=document.querySelector(".cursor-glow");

document.addEventListener("mousemove",(event)=>{

    glow.style.left=event.clientX+"px";

    glow.style.top=event.clientY+"px";

});