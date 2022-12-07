/* jshint esversion: 6 */

const keyBoard = document.getElementById('searchbox');

keyBoard.addEventListener('keydown', e => {
    console.log(e)
    if (e.key === 'Enter') {
        myfunction();   
    }
})

input = document.getElementById('searchbutton');
input.addEventListener('click', myfunction);

function myfunction(){
    document.getElementById('searchbutton');
    fetch("/search?q=" + document.getElementById('searchbox').value)
    .then((response) => response.json())
    .then((data) => {

        console.log(document.getElementById('searchbox').value)

        if (data.length > 0) {
            document.getElementById("responsesize").innerHTML = 
            "<p>" + data.length + " websites retrieved"; // + data[0].time + " seconds</p>";
            let results = data.map((page) =>
            `<ul><a href="${page.url}">${page.title}${ " Score: " + page.score} </a> </ul>`)
            .join("\n");
            document.getElementById("urllist").innerHTML = `<ul>${results}</ul>`;
        } 
        else {
            document.getElementById("responsesize").innerHTML = "<p>No web page contains the query word!</p>";
            document.getElementById("urllist").innerHTML = `<ul></ul>`;
        }
    });
}

  
