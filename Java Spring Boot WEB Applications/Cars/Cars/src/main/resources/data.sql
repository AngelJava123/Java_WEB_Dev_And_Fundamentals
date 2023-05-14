INSERT INTO roles(id, role)
VALUES (1, "PRIVATE_USER"),
       (2, "DEALER");

INSERT INTO users(id, email, password, username)
VALUES (1, "charlisasi@abv.bg", "9cfc1b893228dec4fb8bd03b86e308105318d8ea026e3ee3f6cb5da84dc4cb6f0b6cc224b7c486a2", "angelvtashev");

INSERT INTO contacts(id, web_site_name, address, mobile_phone, working_hours, info_email, LTD, FD, VAT, fax)
VALUES(1, "autogenius.bg", "1221 Bulgaria Blvd. Sofia, №85, bl. 324", "02 5610 307", "9:00 - 18:00 /without weekends/",
          "info@autogenius.bg", "GOLD STANDARD LTD", "F.D. 1380/18 - SGS", "BG571943287", "02/9156890");

INSERT INTO terms(id, welcome, use_of_service, intellectual_property, third_party, warranties, liability, indemnification, modification, law, resolution, agreement)
VALUES(1, "Welcome to autogenius.bg. These terms and conditions ('Agreement') apply to your use of the website, any content, features, or services provided by autogenius.bg ('Service'). By accessing or using the Service, you agree to be bound by this Agreement. If you do not agree to these terms, please do not use the Service.",
"You may use the Service only for lawful purposes and in accordance with this Agreement. You are responsible for ensuring that all information you provide to the Service is accurate, current, and complete.",
"The Service and its entire contents, features, and functionality (including but not limited to all information, software, text, displays, images, video, and audio, and the design, selection, and arrangement thereof) are owned by autogenius.bg, its licensors, or other providers of such material and are protected by United States and international copyright, trademark, patent, trade secret, and other intellectual property or proprietary rights laws.",
"The Service may contain links to third-party websites or services that are not owned or controlled by autogenius.bg. We have no control over, and assume no responsibility for, the content, privacy policies, or practices of any third-party websites or services. You acknowledge and agree that autogenius.bg shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with the use of or reliance on any such content, goods or services available on or through any such websites or services.",
"The Service is provided on an 'as is' and 'as available' basis, without any warranties of any kind, either express or implied. autogenius.bg disclaims all warranties, express or implied, including but not limited to implied warranties of merchantability, fitness for a particular purpose, and non-infringement.",
"In no event shall autogenius.bg, its affiliates, licensors, or service providers be liable for any direct, indirect, incidental, special, consequential, or punitive damages, including but not limited to, damages for loss of profits, goodwill, use, data, or other intangible losses arising out of or in connection with your use of the Service or inability to use the Service.",
"You agree to indemnify and hold autogenius.bg harmless from any claim or demand, including reasonable attorneys' fees, made by any third-party due to or arising out of your breach of this Agreement or your violation of any law or the rights of a third-party.",
"autogenius.bg may modify this Agreement at any time by posting revised terms on the Service. Your continued use of the Service after such modifications shall constitute your agreement to be bound by the modified Agreement.",
"This Agreement shall be governed by and construed in accordance with the laws of the state of Bulgaria, without giving effect to any principles of conflicts of law.",
"Any dispute arising out of or relating to this Agreement or your use of the Service shall be resolved by binding arbitration in accordance with the Commercial Arbitration Rules of the American Arbitration Association. The arbitration shall take place in Sofia, Bulgaria. Judgment on the award rendered by the arbitrator(s) may be entered in any court having jurisdiction thereof.",
"This Agreement constitutes the entire agreement between you and autogenius.bg");

INSERT INTO categories(id, category)
VALUES(1, "Sedan"),
      (2, "Hatchback"),
      (3, "Coupe"),
      (4, "SUV"),
      (5, "Cabrio"),
      (6, "Truck"),
      (7, "VAN");

INSERT INTO colors(id, paint)
VALUES(1, "Black"),
      (2, "White"),
      (3, "Gray"),
      (4, "Silver"),
      (5, "Red"),
      (6, "Blue"),
      (7, "Green"),
      (8, "Yellow"),
      (9, "Orange"),
      (10, "Purple"),
      (11, "Pink"),
      (12, "Brown"),
      (13, "Beige"),
      (14, "Gold"),
      (15, "Bronze"),
      (16, "Copper"),
      (17, "Turquoise"),
      (18, "Magenta"),
      (19, "Olive"),
      (20, "Teal");

INSERT INTO gear_boxes(id, gear_box_type)
VALUES(1, "Automatic"),
      (2, "Manual"),
      (3, "Semi-Automatic");

INSERT INTO engines(id, cubic_capacity, engine_type, euro_standard, power)
VALUES(1, 2000, "Gasoline", "EURO5", 170);

INSERT INTO safeties(id, acc, abs, aeb, bsd, esc, fcw, ldw, rvc)
VALUES(1, 1, 1, 1, 0, 1, 0, 0, 0);

INSERT INTO exteriors(id, alloy_wheels, automatic_headlights, fog_lights, led_headlights, power_side_mirror_adjustment, rain_sensing_wipers, sunroof)
VALUES(1, 0, 1, 1, 1, 1, 1, 1);

INSERT INTO interiors(id, backup_camera, bluetooth, dual_climate_control, heated_seats, leather_seats, navigation_system, power_locks, power_windows, push_button_start, sunroof)
VALUES(1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1);

INSERT INTO protections(id, airbags, alarm_system, anti_theft_system, backup_camera, parking_sensors, remote_keyless_entry, tire_pressure_monitoring)
VALUES(1, 1, 1, 1, 0, 1, 0, 1);

INSERT INTO comforts(id, air_conditioning, cruise_control, heated_mirrors, heated_steering_wheel, power_steering, rear_defrost, remote_engine_start, remote_trunk_release, telescoping_steering_wheel, tilt_steering_wheel)
VALUES(1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1);

INSERT INTO others(id, adaptive_headlights, android_auto, apple_carplay, heated_rear_seats, multi_zone_climate_control, panoramic_sunroof, power_adjustable_pedals, power_tailgate, premium_sound_system, wireless_charging)
VALUES(1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0);

INSERT INTO cars(id, make, model, price, month, year, engine_id, category_id, gear_box_id, mileage, color_id, safety_id, exterior_id, interior_id, protection_id,  comfort_id, other_id, additional_information, date_added, phone_number, location, user_id, visits, favourite)
VALUES(1, "Volkswagen", "Tiguan", 16400, "June", "2010", 1, 4, 2, 245000, 1, 1, 1, 1, 1, 1, 1, "New importation . . SWITZERLAND. . . 4x4. . . . Navigation. . . . Service book. . . Very good technical and visual condition. . . . Solid undercarriage - Preserved Interior - Motor and Box work perfectly. . . Very Strong and Practical Jeep. . . All systems and units are 100% functional. The car was bought directly from the owner, uniquely preserved. The car is sold with an invoice and a contract from the company, at any time convenient for you. I assist in the extraction of transit insurance numbers. ALL VEHICLES IN THE DEALERSHIP HAVE CATALYTIC DEVICES AVAILABLE. ! !", NOW(), "0883967584", "123 Main Street, Apt 4, Paris 75001, France", 1, 0, 0);

INSERT INTO car_image_paths(car_id, image_path)
VALUES(1, "https://res.cloudinary.com/dms1ciius/image/upload/v1684100462/AutoGeniusImages/tiguan1_nler47.jpg"),
(1, "https://res.cloudinary.com/dms1ciius/image/upload/v1684100462/AutoGeniusImages/tiguan2_avsszh.jpg"),
(1, "https://res.cloudinary.com/dms1ciius/image/upload/v1684100462/AutoGeniusImages/tiguan3_x07cs8.jpg"),
(1, "https://res.cloudinary.com/dms1ciius/image/upload/v1680425018/AutoGeniusImages/tiguan4_x7n8dy.jpg"),
(1, "https://res.cloudinary.com/dms1ciius/image/upload/v1680425018/AutoGeniusImages/tiguan5_gcbgpy.jpg"),
(1, "https://res.cloudinary.com/dms1ciius/image/upload/v1680425018/AutoGeniusImages/tiguan6_pxmtew.jpg");
