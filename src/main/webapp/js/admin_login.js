var signin = document.getElementById("form_container2")
var login = document.getElementById("form_container1")

signin.style.display = "none"

function fun1() {
	login.style.display = "none"
	signin.style.display = "block"
}
function fun2() {
	login.style.display = "block"
	signin.style.display = "none"
}

var input1 = document.getElementById("username1")
var password1 = document.getElementById("pass1")
var para1 = document.getElementById("para1")

input1.addEventListener("input", (evt) => {
	var value = input1.value
	var size = value + ""

	if ((size.includes("@"))) {
		para1.textContent = "."
	}
	else if (size == "") {
		para1.textContent = "."
	}
	else {
		para1.textContent = "Invalid Mail-Id or Username"
	}
})

var input2 = document.getElementById("name")
var para2 = document.getElementById("para2")

input2.addEventListener("input", () => {
	var value = input2.value
	var size = value + ""

	for (i = '0'; i <= '9'; i++) {
		if (!(size.includes(i))) {
			para2.textContent = "."
		}
		else {
			para2.textContent = "Name should contain only alphabets"
			break
		}
	}

})

var input3 = document.getElementById("username2")
var para3 = document.getElementById("para3")

input3.addEventListener("input", () => {
	var value = input3.value
	var size = value + ""

	if ((size.includes("@"))) {
		para3.textContent = "."
	}
	else if (size == "") {
		para3.textContent = "."
	}
	else {
		para3.textContent = "Wrong Mail-Id"
	}
})

var i1 = document.getElementById("i1")
var i2 = document.getElementById("i2")
var pass1 = document.getElementById("pass1")

i2.style.display = "none"

i1.addEventListener("click", () => {
	i1.style.display = "none"
	pass1.setAttribute("type", "text")
	i2.style.display = "block"
})
i2.addEventListener("click", () => {
	i1.style.display = "block"
	pass1.setAttribute("type", "password")
	i2.style.display = "none"
})

var i3 = document.getElementById("i3")
var i4 = document.getElementById("i4")
var pass2 = document.getElementById("pass2")

i4.style.display = "none"

i3.addEventListener("click", () => {
	i3.style.display = "none"
	pass2.setAttribute("type", "text")
	i4.style.display = "block"
})
i4.addEventListener("click", () => {
	i3.style.display = "block"
	pass2.setAttribute("type", "password")
	i4.style.display = "none"
})

var i5 = document.getElementById("i5")
var i6 = document.getElementById("i6")
var pass3 = document.getElementById("confirm_pass")

i6.style.display = "none"

i5.addEventListener("click", () => {
	i5.style.display = "none"
	pass3.setAttribute("type", "text")
	i6.style.display = "block"
})
i6.addEventListener("click", () => {
	i5.style.display = "block"
	pass3.setAttribute("type", "password")
	i6.style.display = "none"
})

// For Submission

var main = document.getElementById("container")
document.getElementById("error1").style.display = "none"
document.getElementById("error2").style.display = "none"

main.addEventListener("click", (element) => {

	let value1 = input1.value
	let value2 = password1.value

	let trigerred = element.target
	
	if ((trigerred.id == "butt1") && (value1 == "" || value2 == "")) {
		element.preventDefault()
		trigerred.nextElementSibling.style.display = "block"
		trigerred.nextElementSibling.textContent = "Please fill All the Fields !!!"
		trigerred.nextElementSibling.style.color = "red"
	}
	else if ((trigerred.id == "butt1") && (value1 != "" || value2 != "")) {
		trigerred.nextElementSibling.textContent = ""
		trigerred.nextElementSibling.style.color = "red"
	}

	let passValue1 = pass2.value + ""
	let passValue2 = pass3.value + ""
	
	let name = input2.value + ""
	let signuser = input3.value + ""

	if ((trigerred.id == "butt2") && (passValue1.localeCompare(passValue2)) != 0) {
		element.preventDefault()
		trigerred.nextElementSibling.style.display = "block"
		trigerred.nextElementSibling.textContent = "Password Not Matching !!!"
		trigerred.nextElementSibling.style.color = "red"
	}
    else if(trigerred.id == "butt2" && (name == "" || signuser == "" || passValue1 == "" || passValue2 == "")){
		element.preventDefault()
		trigerred.nextElementSibling.style.display = "block"
		trigerred.nextElementSibling.textContent = "Please fill All the Fields !!!"
		trigerred.nextElementSibling.style.color = "red"
	}

}, false)