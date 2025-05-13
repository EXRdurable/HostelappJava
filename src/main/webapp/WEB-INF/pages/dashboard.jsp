<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><
!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hostel Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .sidebar {
            height: 100vh;
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            background-color: #343a40;
            padding-top: 20px;
        }
        .sidebar .nav-link {
            color: white;
            padding: 10px 20px;
        }
        .sidebar .nav-link.active {
            background-color: #007bff;
        }
        .main-content {
            margin-left: 250px;
            padding: 20px;
        }
        .section-content {
            display: none;
        }
    </style>
</head>
<body>
		
    <div class="sidebar">
        <div class="text-center mb-4">
            <h4 class="text-white">Hostel Management</h4>
            <p class="text-muted">Admin Dashboard</p>
        </div>
        
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="#dashboard" id="dashboard-link">
                    <i class="fas fa-tachometer-alt"></i> Dashboard
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#users" id="users-link">
                    <i class="fas fa-users"></i> Users
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#rooms" id="rooms-link">
                    <i class="fas fa-bed"></i> Rooms
                </a>
            </li>
            
          
        </ul>
    </div>
    
    <div class="main-content">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 id="section-title">Dashboard</h2>
            <div>
                <span class="me-3">Welcome, Admin</span>
                <a href="${pageContext.request.contextPath}/admindashboard?action=logout">Logout</a>
            </div>
        </div>
        <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </c:if>
        
       <div id="dashboard-section" class="section-content">
    <div class="row mb-4">
        <div class="col-md-4">
            <div class="stat-card">
                <h3>Total Rooms</h3>
                <div class="stat-value">${totalRooms}</div>
                <div class="stat-change increase">
                    <i class="fas fa-arrow-up"></i> Live count from DB
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="stat-card">
                <h3>Total Hostelers</h3>
                <div class="stat-value">${totalHostelers}</div>
                <div class="stat-change increase">
                    <i class="fas fa-arrow-up"></i> Active users
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="stat-card">
                <h3>Total Revenue</h3>
                <div class="stat-value">$15,000</div>
                <div class="stat-change increase">
                    <i class="fas fa-arrow-up"></i> 12% from last month
                </div>
            </div>
        </div>
    </div>
</div>
        
        <!-- Users Section -->
        <div id="users-section" class="section-content">
            <h3>Users Management</h3>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Address</th>
                        <th>Phone Number</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Profile Image</th>
                        <th>Actions</th> 
                    </tr>
                </thead>
                <tbody>
                    <!-- Example row, repeat for each user -->
                   <c:forEach var="user" items="${users}">
				    <tr>
				        <td>${user.id}</td>
				        <td>${user.username}</td>
				        <td>${user.address}</td>
				        <td>${user.phoneNumber}</td>
				        <td>******</td> <!-- Masked password -->
				        <td>${user.email}</td>
				        <td><img src="${pageContext.request.contextPath}/resources/images/profile_images/${user.profileImage}" alt="${room.imagePath}" style="max-width: 100px; height: auto;"></td>
				        <td>
					    <form method="post" action="${pageContext.request.contextPath}/admindashboard" onsubmit="return confirm('Are you sure you want to delete this user?');">
					        <input type="hidden" name="action" value="deleteUser">
					        <input type="hidden" name="userId" value="${user.id}">
					        <button type="submit" class="btn btn-danger btn-sm">Remove</button>
					    </form>
						</td>
				    </tr>
				</c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Rooms Section -->
        <div id="rooms-section" class="section-content">
            <h3>Rooms Management</h3>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Room ID</th>
                        <th>Room Type</th>
                        <th>Price</th>
                        <th>Rating</th>
                        <th>Description</th>
                        <th>Image Path</th>
                        <th>Actions</th> <!-- Add this to the table header -->
                    </tr>
                </thead>
                <tbody>
				<c:forEach var="room" items="${rooms}">
				   <tr>
				    <td>${room.roomId}</td>
				    <td>${room.roomType}</td>
				    <td>${room.price}</td>
				    <td>${room.rating}</td>
				    <td>${room.description}</td>
				    <td><img src="${pageContext.request.contextPath}/resources/images/rooms/${room.imagePath}" alt="${room.imagePath}" style="max-width: 100px; height: auto;"></td>
				    <td>
				        <!-- Edit Button -->
				        <button type="button" class="btn btn-warning btn-sm" onclick="toggleEditForm(${room.roomId})">Edit</button>
				
				        <!-- Delete Form -->
				        <form method="post" action="${pageContext.request.contextPath}/admindashboard" style="display:inline;" onsubmit="return confirm('Delete this room?');">
				            <input type="hidden" name="action" value="deleteRoom" />
				            <input type="hidden" name="roomId" value="${room.roomId}" />
				            <button type="submit" class="btn btn-danger btn-sm">Remove</button>
				        </form>
				    </td>
				</tr>
				
				<!-- Hidden Update Form -->
				<tr id="edit-form-${room.roomId}" style="display: none; background-color: #f9f9f9;">
				    <form method="post" action="${pageContext.request.contextPath}/admindashboard">
				        <input type="hidden" name="action" value="updateRoom" />
				        <input type="hidden" name="roomId" value="${room.roomId}" />
				        <td>${room.roomId}</td>
				        <td><input class="form-control" type="text" name="roomType" value="${room.roomType}" required /></td>
				        <td><input type="number" step="0.01" name="price" value="${room.price}" required /></td>
				        <td><input type="number" step="0.1" name="rating" value="${room.rating}" required /></td>
				        <td><input type="text" name="description" value="${room.description}" /></td>
				        <td><input type="text" name="imagePath" value="${room.imagePath}" /></td>
				        <td>
				          	<button type="submit" class="btn btn-primary btn-sm">Update</button>
				            <button type="button" class="btn btn-secondary btn-sm" onclick="toggleEditForm(${room.roomId})">Cancel</button>
				        </td>
				    </form>
				</tr>
				</c:forEach>

                </tbody>
            </table>
            <!-- Add Room Button -->
<div class="text-end mt-3">
    <button class="btn btn-success" onclick="toggleAddForm()">+ Add Room</button>
</div>

<!-- Add Room Form (hidden initially) -->
<div id="add-room-form" class="mt-3" style="display: none; background-color: #f1f1f1; padding: 20px; border-radius: 8px;">
    <form method="post" action="${pageContext.request.contextPath}/admindashboard">
        <input type="hidden" name="action" value="addRoom" />
        <div class="row">
            <div class="col-md-2">
                <input type="text" class="form-control" name="roomType" placeholder="Room Type" required />
            </div>
            <div class="col-md-2">
                <input type="number" class="form-control" step="0.01" name="price" placeholder="Price" required />
            </div>
            <div class="col-md-2">
                <input type="number" class="form-control" step="0.1" name="rating" placeholder="Rating" />
            </div>
            <div class="col-md-3">
                <input type="text" class="form-control" name="description" placeholder="Description" />
            </div>
            <div class="col-md-2">
                <input type="text" class="form-control" name="imagePath" placeholder="Image Path" />
            </div>
            <div class="col-md-1">
                <button type="submit" class="btn btn-primary w-100">Add</button>
            </div>
        </div>
    </form>
</div>
        </div>

     

        
    </div>

   
    <script>
    
    function toggleEditForm(roomId) {
        const formRow = document.getElementById('edit-form-' + roomId);
        formRow.style.display = (formRow.style.display === 'none') ? '' : 'none';
    }

    function toggleAddForm() {
        const addForm = document.getElementById('add-room-form');
        addForm.style.display = (addForm.style.display === 'none') ? 'block' : 'none';
    }
        function showSection(sectionId) {
            const sections = document.querySelectorAll('.section-content');
            sections.forEach(section => {
                section.style.display = 'none';
            });

            document.getElementById(sectionId).style.display = 'block';
        }

        // Sidebar link click events to show corresponding section
        document.getElementById('dashboard-link').onclick = function() {
            showSection('dashboard-section');
        };
        document.getElementById('users-link').onclick = function() {
            showSection('users-section');
        };
        document.getElementById('rooms-link').onclick = function() {
            showSection('rooms-section');
        };

        document.getElementById('reports-link').onclick = function() {
            showSection('reports-section');
        };
        document.getElementById('settings-link').onclick = function() {
            showSection('settings-section');
        };
	
        // Initialize with the Dashboard section displayed
        showSection('dashboard-section');
        
    </script>
</body>
</html>
