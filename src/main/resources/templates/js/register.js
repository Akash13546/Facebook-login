function register() {
  fetch("/api/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      username: username.value,
      password: password.value
    })
  })
  .then(res => {
    if (!res.ok) throw new Error("Registration failed");
    return res.text();
  })
  .then(msg => {
    alert("Registration Successful");
    window.location.href = "login.html";
  })
  .catch(err => msg.innerText = err.message);
}
