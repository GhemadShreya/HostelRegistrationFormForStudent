const API_BASE = "http://localhost:8045/api/students";

document.getElementById('studentForm').addEventListener('submit', async function (e) {
    e.preventDefault();

    const form = e.target;
    const formData = new FormData();

    // Create a student object to stringify
    const studentData = {
        studentName: form.studentName.value,
        collegeName: form.collegeName.value,
        branch: form.branch.value,
        classYear: form.classYear.value,
        age: form.age.value,
        contactNo: form.contactNo.value,
        nativeAddress: form.nativeAddress.value,
        parentsName: form.parentsName.value,
        pContact: form.pContact.value
    };

    formData.append("student", new Blob([JSON.stringify(studentData)], { type: "application/json" }));
    formData.append("photo", form.photo.files[0]);
    formData.append("fees", form.fees.files[0]);

    try {
        const response = await fetch(`${API_BASE}/register`, {
            method: 'POST',
            body: formData
        });

        const message = await response.text();
        alert(message);
        form.reset();
        fetchAllStudents();
    } catch (error) {
        console.error("Error:", error);
        alert("Registration failed");
    }
});

async function fetchAllStudents() {
    try {
        const res = await fetch(`${API_BASE}/all`);
        const students = await res.json();
        const list = document.getElementById('studentList');
        list.innerHTML = '';
        students.forEach(student => {
            const item = document.createElement('li');
            item.textContent = `${student.studentName} - ${student.collegeName} (${student.branch})`;
            list.appendChild(item);
        });
    } catch (err) {
        console.error("Error fetching students:", err);
    }
}
