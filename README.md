# Parcel Tracking System (PTS)

## Overview

The **Parcel Tracking System (PTS)** is a Java-based application that allows users to track and manage parcel information. It provides a graphical user interface (GUI) built with **Swing** components, enabling users to add, update, and view parcel details.

The system maintains a collection of parcels in a **HashMap** and provides the following functionalities:
1. **Add Parcel**: Users can input parcel details to add a new parcel.
2. **Update Parcel**: Users can update the location and status of an existing parcel using its Parcel ID.
3. **View Parcel**: Users can view the details of a parcel by providing its Parcel ID.

This application is implemented using the **Swing** library for the UI and basic **HashMap** operations for storing and managing parcel data.

---

## Features

### 1. Add Parcel
The **Add Parcel** tab allows users to input parcel details such as:
- Parcel ID
- Sender Name
- Receiver Name
- Location
- Status

After filling out the fields, users can click the **Add Parcel** button to save the new parcel in the internal parcel database.

![Add Parcel Tab](images/1.png)

### 2. Update Parcel
The **Update Parcel** tab allows users to update the location and status of an existing parcel using its Parcel ID. If the Parcel ID exists in the database, the details are updated. Otherwise, an error message will be shown.

![Update Parcel Tab](images/2.png)

### 3. View Parcel
The **View Parcel** tab allows users to enter a Parcel ID and view its details (ID, sender, receiver, location, and status). If the Parcel ID exists, the details are displayed; if not, a "Parcel not found" message is shown.

![View Parcel Tab](images/3.png)

---

## Requirements

To run this application, you need:
- **Java 8** or higher
- **Swing library** (included in standard Java distributions)

---

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/parcel-tracking-system.git
