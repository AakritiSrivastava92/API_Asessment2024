import requests


class DataFetcher:
    @staticmethod
    def fetch_data(url):
        # GET request to the API endpoint
        response = requests.get(url)

        # Checking for various status codes
        if response.status_code == 200:
            data = response.json()
            print("Data fetched successfully:")
            print(data)
        elif response.status_code == 404:
            print("Resource not found. Status code:", response.status_code)
        elif response.status_code == 401:
            print("Unauthorized access. Status code:", response.status_code)
        # Add more checks for other status codes as needed
        else:
            print("Failed to fetch data. Status code:", response.status_code)

    @staticmethod
    def data_post(post_url, data=None):
        # POST request to the API endpoint
        response = requests.post(post_url, data=data)

        # Handling the response
        if response.ok:
            data = response.json()
            print("Data fetched successfully (POST):")
            print(data)
        else:
            print("Failed to fetch data (POST). Status code:", response.status_code)
