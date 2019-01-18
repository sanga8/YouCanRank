<script src="https://apis.google.com/js/platform.js" async defer></script>

// Called when Google Javascript API Javascript is loaded
function HandleGoogleApiLibrary() {
	// Load "client" & "auth2" libraries
	gapi.load('client:auth2',  {
		callback: function() {
			// Initialize client & auth libraries
			gapi.client.init({
		    	apiKey: 'AIzaSyAuIUdHyDgB6xkVRs2ZQoBD8ZMfhoxgNO0',
		    	clientId: '800412684804-uaoedh302k7601j2vq6j96n87g1o3uci.apps.googleusercontent.com',
		    	scope: 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/plus.me'
			}).then(
				function(success) {
			  		// Libraries are initialized successfully
		  			// You can now make API calls
				}, 
				function(error) {
					// Error occurred
					// console.log(error) to find the reason
			  	}
			);
		},
		onerror: function() {
			// Failed to load libraries
		}
	});
}

// Call login API on a click event
$("#google-login-button").on('click', function() {
	// API call for Google login
	gapi.auth2.getAuthInstance().signIn().then(
		function(success) {
			// Login API call is successful	
		},
		function(error) {
			// Error occurred
			// console.log(error) to find the reason
		}
	);
});

// API call to get user profile information
gapi.client.request({ path: 'https://www.googleapis.com/plus/v1/people/me' }).then(
	function(success) {
		// API call is successful

		var user_info = JSON.parse(success.body);

		// user profile information
		console.log(user_info);
	},
	function(error) {
		// Error occurred
		// console.log(error) to find the reason
	}
);




<div class="g-signin2" data-onsuccess="onSignIn"></div>

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  }