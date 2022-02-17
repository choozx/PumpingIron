<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	
<head>
<meta charset="UTF-8">
<title>Pumping Iron</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/css/member/login.css" rel="stylesheet">
<link href="resources/css/member/join.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/f44a228655.js"
	crossorigin="anonymous"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/member/member.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				function setCookie(name, value, expiredays) {
					var today = new Date();

					console.log(today.getDate())

					today.setDate(today.getDate() + expiredays); // 현재시간에 하루를 더함 

					document.cookie = name + '=' + escape(value) + '; expires='
							+ today.toGMTString();

				}

				function getCookie(name) {

					var cookie = document.cookie;

					if (document.cookie != "") {
						var cookie_array = cookie.split("; ");
						console.log(cookie_array)
						for ( var index in cookie_array) {
							var cookie_name = cookie_array[index].split("=");
							if (cookie_name[0] == "mycookie") {
								return cookie_name[1];
							}
						}
					}
					return;
				}

				$(".modal-today-close").click(function() {
					$("#myModal").modal("hide");
					setCookie("mycookie", 'popupEnd', 1);
				})

				$("#modal-close").click(function() {
					$("#myModal").modal("hide");
				})

				var checkCookie = getCookie("mycookie");

				if (checkCookie == 'popupEnd') {
					$("#myModal").modal("hide");
				} else {
					$('#myModal').modal("show");
				}

			});
</script>
</head>
<body>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h1 style="font-family: facon">Pumping Iron</h1>
					<br> Pumping Iron에 오신걸 환영합니다.<br> 운동인들을 위하여 쇼핑 + 커뮤니티 기능을
					합친 사이트입니다.<br> <span style="color: red;">전국 어디서나 동일한 1일권 가격 (제휴된 헬스장 한정)</span><br>
					피트니스 센터 1일권 정보, 운동 루틴 기록 등 다양한 기능을 체험해보세요.
					<img
						class="mt-3"
						src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBUVEhgVEhUYGBgYGBgYGhgZGRgYGBgcGhgZGRoYGBgcIS4lHB4rHxgYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QHxISHzQoJSs0NDQ0NDQ0NDQ0PTE0NDQ0PTQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NP/AABEIAK8BHwMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAGAAIDBAUHAQj/xABBEAACAQICBgYHBgUDBQEAAAABAgADEQQhBQYSMUFRImFxgZGxBxMyQnKhwSMzUmKy0RSCkuHwJDSiFVOjwuJj/8QAGgEAAgMBAQAAAAAAAAAAAAAAAQMAAgQFBv/EACYRAAICAgICAgICAwAAAAAAAAABAhEDMRIhBEEyUSJhE6EFcYH/2gAMAwEAAhEDEQA/AL4E9AiBjw0yDRtp7aOBHKOykIR2ntpJsdcWzDQLGWnoE9tHAQkGgSzb7L+f6S7gNCVamdthfxN9BN2lq7TAUMWYA3I3XP7S8Ysq5fQL4TCvUNqalvIdphFgtXBvqtf8q7u8zeo0VUWQBRyAtJIxRSKvsio4dEFkUKOoSaKKWINM51h/ZPxN5mdFM51R3H4m/UYzH7E5do2NXPvj8B8xC1d0D9Xj9v8Ayn6QwXdBPYcWh0UUUoNFFFFIQUUUUhBRRRSEFFFFIQ43ppbaWxQ5sh8aVOeOsm1kW2mMR1rSP/jUfSMYSS2VjorssaVkrCMIlC5GVnhWSERpgIRkTy0eZ5aQhtie2mcmMcbxJ0xo4iJ4svyRbtPbSNaymTol92cPBk5IaBHCa2B0DVc9IbC8239wl3S+hEpYdmUksovcnfnylo42ysppKwcLW3wn1d0ep2ahF7rcX4Xgtsc4d6BH2SfAJoWNRViebk6NWexRQDBRRRSEFFFFIQaZzmhuPxN+ozoxnOcPuPxN5mMx+xOXaNbV/wC//lP0hgu6B2r/AN+Phb6QxTdBPYceh0UH9YdbMNg8qzEuRcU0G0xHM8AO0wHT0lYis5FCnQUXvZy7NbkSCB5StDTq8U5vR18xG+pTpWHtFQ/R7QX/ALdct4b0j0toLVUgXsXUNZe0Hf3GVsNMPopFRqq6hkYFWFwQbgg7iDJYQCiiikIKKKKQhyXW5baYf81Gmf1D6SFxLmvSW0qjfiw6/J6n7yo8kisdELCMIkrRhlC5ERPCI8iNMBBhnkeY0wBNj1K8o5MErGwUk8gLmaWhtHGuwzsuefZDXBaOp0h0FF+e8nvgjGXsDa9AjgtUWaxc7A5e9/aFOjtD0qI6C3P4jmfGaMUcuitCmRrP/tX7vMTXmRrR/tX/AJf1CFbBL4sB33Q90KPs1+BfKAbiH2iR9mPhXyjZ6E49mhFPLwP03p5nYpRbZQZM43t2HgvnM7kkrNKVhNiNIUk9t1B5XufASqdO0eBY9iwGGMUbszzzPyESYza5j+Vh87SiyNhcaDunpuieLDtX9pfpVVYBlIIPEG4nO1xRX3Ce+0t6JxtRahdbhTbaTerfseuXv7Aoth4d05zh9x+JvMw+wuJWot17wd4PXAGhuPxN+ox2MRlVNGpoI/bj4WhBpvSH8Phate1yiMwHM2yBtwvaD2hPv17G8oRaYwH8RhqlG9ttCoPI8L9V7QT2HGfPWNxtXE1mes207tcm3yA4ADIDlC3QehVAu9hfsJ8spVwGjlpMwIBdSVJ37jbKbeCqGZZTbOhDEqs3MLo2mBkgPWd5mXpnVhKiEpdWtcD9pu6PbixAHXNJyDBG9lZfRybC4jF4JwUqOFU+ztMUIBzBU8D9Z2jQGlFxOHWsmW1kRlkRkRlAfWOiCD0ct95p+jMbNKqoNxtqw5Zgi4/p+UenaESjTDmKKKEqKKKKQhzP0iZaQw550mHg/wDeZrzS9JgtjMIeaVR4NT/eZzQS9Aj7IWjDJGjDKlhhjTHmNMARhnkcZ5AQ6LqalqK9h8zCeDuqQ+xT4frCGPlsVj0exRRSpc8mPrV/tm7V/UJsTG1q/wBs3xJ+oQx2Vn8WB2xzIA4k7hLraY27g7SoqgKu4sd201vGZuknC0gx9kOLnllYX5DMzNoJtVXqM2zTQBRyJtdj8wPGLz5GnRbBjVWEmkMdXoYRgjbSsLDauXUHeQb5Dqzg7Qu62Z7AbwuXC+ZM29YsYhwLdaEAbsrD+/hAvQOncMyAF9hgLbL2G7LInIjvmduTprsekqYSUqgQZWsO/wAov49Dva3aCfOVxjaVvbXvNvA7pHTpCqT6sM9t+xZrdtjl4Qx2Bous9usdRUjzym/oeujbrG3KCuDwg9ZmrHh0t0M8DTVEAUCOsqkW1bZcOuXAjmOMGKAyPxt+ozcx2MSnTYvtWteyAsx6lABJPUJiUXLC7Agkm4ORB6xz59cdhfbQnOukzR0L9+n83lDOnugXog/bp3/pMM6W6WmLxHF9OYwUsXWVEZgtRwWyVRne1zv3yXAMa216ps1W55jLgOM0PSNokNiw+YBRWsMhtXsSRxPREqalbKVH3KrAnaO7K+0Ziklyo62NvhZhYfEucQUdazW37VQqOf8AnCdH0UW2LEEDhd9s/wBVh5TJ066EJUpBHGdylm3HmPKbGiMalSmNneN8C3RWStciWvhw5F92YI5yPQNRKVYLhwNhnNJ12QCrKGKtfeRkczffJ2cLdmyAzl3QmCVm9eBvBAO7asSL26sxc55Rkbb6FNxSdhBFIq9dEF3ZVHNiAPEwex2vGCp5Ct6xvw0gah8Vy+cdRkckthNFADEa/VWywuDc/mqsEHbsrc/OZ1fSGlK/tV0oKeFNQD/U1zDQOa9EnpSYfxODzF7VcuNiaefyme0FtNYV6eMp+sqvVZt7OxY+J4QoG6VkGIxowyRpGZQYMM8McY0wEGmNjjPJCHTtWFtRT4F8puTJ1fW1JfhXymtHy2Kho9iiilS55MXWoXw9vzp+oTamHrY1sOD+dPOGOyk/izn+tFcJhHsL7TIp7C3Hw+cwF0qjoiE7KrYG+Qy4W4coYVER0ZHAZWGanjnf/D1SzT9G+FqMH26qjK6goQeq5W4i8+OUnaGePljFUznmsesQ9SyKTcjZGRG/gB2cT9YD0qdx/hh76TNXBhcUDTUikyqUOZAsLMlzxuC380DlpXHRzlYR4qhsnydol0ThttwtyOw/vOratYdP4OpTFwbObqbOGFipBO42vn1Gc21fcesAO/dvnQcLVei+3TXbBADJwYfQjnFZX2acEVTNrBKrr6wkMy2Vze9n2QWB8b3mmmKAylRKqBWdKewali4tYkgWBNsibZX7IlIMClQJRV2a6MrjgZSx2Evd0HWw+okai26/d9JXxlRQ4ZgUa3FhuItfokjnH4nJy6M+eMVHsn0V9+naf0mGlLdOd0NM0KVRGd1ABzNxlkRNg6/YIEqHZyOFNGe/VdRb5zRMxQklsdr9gdqitUDNDZvhb/6t4zllDEBawVWG0M9ktsgAnMk7rQ+0nrfUro1Ojg22WBUtVcJkeIVb9u+BWOwQSp9omZzB/uJlyx7s6Xi5k1xDDCFzTK+sps9rBQrVM+TG4kGg8JWp1H9Zsb79C4UAj2Rck5GVtAEIAVIBPj4mboxA3LnfeZR00Xk6bovMl7CDWOxmPZ2RcQKVJSVQU1UNsjIXY3N+y0JsKlgScz/m6e0dWi3SdgNrpWAuc847H0ZM3aoCxoRGO1Xd6rc3Zn8zNHD4Wmn3dMeENaGr1Fd4Ldpt5TQo4Kmnsoo7hfxjLYhRAqlhKr+wht1Ll4y7R1dqt7ZC9p/a8MIoC3E496QtXzQfD1toEM+wcrEHZLDuyMkUZDshJ6Vl/wBLRPLEJ80cQdQdEdkEtIkdtEbCMMkaNMoMIzGmPMaYCDDGmPMaZCHVtCi1Mdg8pqTO0SOh3DymjHS2LhoUUUUBY8mFref9OPjTzm7MDW/7lfjX6y0fkik/iwQczoOjfYHYPKc/dcp0DRp6A7B5Rk9CsexmmNFUsTSNOsgdTmL8DwIPA9c4/rDqK2GqF6Yd6e8ZAlRybgR1ztrOBvIEG9bNKIcOaaMGZ2C9E3sAbt5W74iVV2aoS7pHJcPoclg+za2eXGHWgWB2QRujMPg+gb8pFoN7VLdcy32bFXFmvpqiLdE5zLoYrYyaEWJVeI/cyg2iKtQ2WmQvNrDzhcHJ9AWWMVUiXCOrWIaAPpTq1kqUtg7NNkbNd5cEbQbu2bd8PRqlUVCVqBWtkOkR35ic70lgcTi3ArkAUy6hVBte9mOe8nZEfhhJMy58sHGlYGYAXqKGu12zuSZ0XVfRzsW9XSJHPZ49vCN1f1VRa9Mtn0voZ1LBmlh6djYZk2G890dKJli+Rg4fV6u3tWUdZ+gg9ri9Khs0A+3WLBiBayAcG/MeXLPlCnS+kKlYbFMlE42PSbqJG4dQgvidWEqNtFWVr3214niWHHw74ucG49D8bjGVsysC7sOjNfRFfZqAVCRfnuljC6BdPYZWsew+G75zWqaKV1DldlwN2W/u3xH8cltGt5ovRcFUE2FtxOU2tFYkNTAv0lFiOOW4+ECNC06wr1A6OFtZWKkKewmbiYdw6sOiFa97524gDnnaMjf0JmkvYVRTPpaR4MO8ftLK4tD7wHbl5xtMTaLEU8BnsAQL9KQ/0KnlXpH5kfWDFI9BewQs9Jy30c55PSP/AJFgjhjemvYIJaKx+TPGjDJGjDKDBhjDHmNMBBhjTHmNMBDrWix0PCXpmaLxSlbbQjsXpmhS9uqg6ri/hHvYpNJGjFBHE68URlSR3PO2yPEyhV1jxdTJAtMHkNpvE/tKtpE5r0HbMBvNoDa/6y4elTRBUVn2wdlSCQADmbbpW/6Xia2dQ1H+IkL/AE5D5QS171bqUwhCAAtbLPOxhi3y6RWUrXZi43Xd2JFNMuZyhBonWDH1SoV9mwz2EuT23vB3Qmqu2+1W9ke7u2u08p03RGEVQFUBQNwAAHgJXLlafEZjwqS5ejLrYR6n37u55Oxt3KbD5TSwGhxZRlsrkANwubn5zcFC3G8pVgUchciekvXzX/OYlF+TpmzDhi+lv7LFfD2pkDlMKlhGQhxzhFRcOtwbcCDwPKetTGzawtKyj6B+UG0yxoymDVDflNuo2E3Zg4SuFcHhmPGbFHEK245jeOI7oyGhE07slM5mlPpuB/3H/WZ0wzm1j6xl4l3O+17u1h4ecdB1YiceTSL2EohbOvSYZgAhfAEZmaeCdKgLLmQbMGFmU8mEzsP+FkvbeD0WHZfKI1PV1PWobgWWoDk2xzcc13huIuJawqCRubAFr8Y1yFsbZHiI/EWKXGYNvnKeGezAHNXGXURAAmqLffnPUQ/4TKek9K0sOB6xjc+yigs7dijh1nKYba90UuXoV1Ue9sowHaFYkQ0yrkk6bCpk6zPB1zDw2ueDew9YVvuLowGf5rWE3QQQCDcHMHgeuQse2iAiEeJCCRyvskjsmjhMVtdE7+fP+8oWiUkEEbwbyrVhToo+kZL6LxHUqt4OpgPgGvSTsEP9d12tGYm3Gi58Bf6Tneh2vQTsEXLQVtllowyRpGZQYNMYY8xpgIMMaY8xhgCLV3QOLrgdN7ADMuQBluy3wvwmog31H7lH1MJNAUQtOwHH6TVjmkmIjFPtmDhNVsOnulj1n6Ca9HCoo6KqOwCWJ5IXUUjyDOuyg0kB/wC4PkDNmtpWghs1VAeW0IO62Y+nUpIKbq3T903tkZOXHsnHl0gXp5nLdwhBo0bph4YZzcwJtMnK5WzbxqNI1Q0zNMPY02XgxU9jDL/kqyvpPWLD4e4qVFDfhF2bwEyMPrJRxDFFLKbqUDC20QwOXdGR5WmkHDJRyLsIkex2197Jhz/vLYJIuDcGYP8A1imtRaSsCxtt532ezkTNpVK5KbB+kOo8RG5HF62Oz8X/ALPbmVsVScsr0mKul7A+y6nejctwIPDsJlpGbiBbd1gwF150viS/qsMrqiC7uo2WZjwDb9kZbt94qKk30Zv5OHZ0fRemi52ai7LXCnmCeY5HnA2oweq/xt8iQIF6v6XxNZiErurJkxY33cbNe/ZC3D4d0QVFe+fTyB2W5kcVPymhxaVirjOTcVX6NejUqLa421G4n2wOV+PYZb6FQdE7LjcCAD1jPIjqORlLDY4+/Sv1obf8TlNOi1OpkVPYwsfGFFJJrsh0Rivbwz5OinZGeakG1r52G7PMZb95YMWFosWy9UCx/lF/oZdq6NuQyW20zRmzKniu1vKHcR37xB/ToYrXQCxdHsPiUi3c1xLFEk2B+jse2IepXqG7u5y/Co9lByAB8+c0EUZ34wY1cxgVzTfLaNxf8QyI/wA5QgxuKSkhZzkOHEnkI+DXE52eMlkaFoHCIUqKwFkqsq/CQGAHZtWhZq9jHRv4bIoBtKSTtKD7vYD5zleF04ybRBsXYue0n6boVaoaTL4hWY7xbtuZnyTSRvwQbaTOmrU59fyghpr0hUsPUNNcPVcjezD1Sm2/ZDC7DrtaFbkK1ifabLqyEHNetD+uwbgWDI4emx4DcwJ5EE/KKjN3THyxqrJdBa+YXE5NtUXG8PbZ/rGXjaFDsLAg3B3EbjfkZ86as4j/AFVMHc5KMOpsj850nUbGOtZsMzlksXQb9hl3heSkG9ua9Zj12rM76dB/pldrR2IX/wDKqP8AixnNNXnvhk7B5TqjptYWsvNXHik5Hqm18KnUBFS0Wjv/AIa7SMyRpGYsYNMbHmMMBBpjTHGNMATq+i8kl5Wg82NNMDrk+C0qPe4zQzOpV0P0xrBSwxCvtMxz2VF7DmSd0DtY9cErN6ui5CAXb3SxPDsExPSRphlxBNMZFBe4OZz3d05RUxDEliSC2e8xLbbaQ9JUmHuNxFzk8u6u1Syvc3swA8IO6vUwae2elwzhPoqkqK2yLXIJ8IlurQ+ENSNii2c1cNUy7piLUl3BvnFJ9mhx6Oe6Rpnbdr3YMWa/E3zmycTgigYKFewNwSCG55S5rDq5Vaoz4dA4e5K3AKtxtfIiBWF0FiHfZZdkA2YkjKxztzm6GWonLw+LnlOSpvvokbFD+LV8MrXX7wkkg9ZvxnYMBi1q4QMX2WC3HV2Tn9DCJSGyq+PGaeBxHu338OUyTzXLR0o4HBcZbDHB6XQ0lZwdoZEDceuCvpG0g4po9AMtyyueFrZX67zWoJYW4DOWKxVhssAVtaxFx4R2Hk3YyHirLd6OM6IqVBUc07lm/DcnPsnVdUsPUp0LVvacliDwBy2T3S5RwtNMqaInwqBJduaUjRh8KONt3bZEaLo1ka44XzNpew+kUBs7rtDgtye8C9pi6xsTh9oMRsst7Ei4PRsbbxciU9DjaGURky8JcUhU/CVOTfR0DDYtW3X8DB/WIf6pFX312u4ZN+le+WsDUKkA+Mp45h/FFz7iKo6rksfHo+EZDJy2cyePi+jH1g1Ko4h9qmxpVGFzYXRm5leB6wRA/TGpmNQ9MNVAyDI23/xNiPCdUwLgA1HNh15TF0rrRTQkJ02G4D2b9bcuyGU4xVtgjinklSVnLE0HV29moCljntCzDjuhLgqC09n1e8W8ecjxOKerUZ6h6Tm5sLAZAAAcBYCXsFh72nOyZHN0tHTjhhiX79my+k6zlbtYLnItO63nD0XWqFdqisqJ2i1z+XPfNzRurp2b1GKlhkotccib+VoMaQ9FdZ6pc40Pc76lNg1uXRYjwt2TTjxS2zJlzR0jnGiDsVA9/Yz74f8Ao0ZquMZ/dpoxY9bnZUfq8Jap+ih8gcSgHEhGJ7hcecL9F6Ho4CmlKiD0rszHN3YWuWO4ZZW4TUnWzG1egmw5yZT7ynxsf87pyDVTKiV/CzDwJE6lSxXTQMLKTa98wT7Pdecr1ayNZfw1qo8HYRcpJroii0+zbaRmSGRmLGHhjTHGMMARpjTHGNMhA10w1gvfKGEeXNYDYL3zOwjx0mYpbNJ8Mj+2gY2tcic11n9H9VXerSAZLlrbtm+ZtOl4VrmVtYtNqtM0kN2bI24CUtJWx2K26RznQeANOnZpr4XIkcJC72nmKSotakUzQg7RHWp399pmpyZ0orhG2nRe9ZLmEeZNR85fwBLRT2ProIUrAISTkAT8oCrirsQOJJ3884QaYqslB1G9hsjvyg3h6GyOZta/ZGRlSs3eFlhgjKUu29InqNkBNDRVNdq5AlCjQLGbVCh6tL+8d37xSuchLbzT/bNCtXFthRlxPPqniPKNJGl6nRPG57J0YKlSN6xxxxpHpeMLyX1P5T3kTw0+q3zl+wJxMrWKvs4V+vZA7dpZiaK0psLe1zwEm10dgiKB0CxJPWBkPmT3TBpA2mHyJfkNhGE4uLCR9aKrZAhR1DPxMpV9L1GJO1md/XMxElhKd5n5v7ETwYY6SPauLqOLO7EDcLm3hIlp3l2lh78JcoYUk2VbnlDTkZJ5YxVR6RUweBLEX47uvqE6Bq9oRKYD1BtPvz3L1Ac5U0TowUztPYv+ns65v02v0V7zy/vN2HAo9vZyc/kOT4x0WaXSYtw3CSrvjQLCwjkmkyD1mTp3II3JiPEX/wDWa4mRrKv2Bb8Do3z2f/aVl8WWh8kMB2kgBgcC1DE4hGubuzqeauSwPiSO6GGDxQ2RnvjNM4QOoqKOkosetT+xz8ZmizRKPRiGMaPMaZYUNMYY8xhgCNMaY8xhkIGOnnHR7DB+pidgXmtp577PZBbGvwl8joywjylRLW0w5Fl6I+cpK57zxjKhyjEbKLjUtnrf8fhwzw04q0xtfMxqYh19425RVDINvpWiZSdmLycznNr0tIvVd8dQ0iU9gd8ifpKOy30jKagSjXdik7RZqu7naqG/kOwR9KnnIfWy3hTKSl6RZR9mhhaQk7UrtdjblmN09pUtwIBG83mhSw62uEUdwjsUlH0NxZ44rddlakFHvX7LfSXadFjuVvAjzkdPEdO1rWmslbKPWd+kDJ5cvSM9qTj3D4r+8Y1JrZofFf3mneMqSPNIUvKl9IEdK4dKqtTOQbdcEFWByJB5H5QMai6OyVBZkYqw5EQ20o9q5Hwme676GJKYmna9grjIXFui3bwPVaTPj5QUlsR4nm8c0oy03/YH0kJlyjT5yOitsyMps6Kwe24AyyuT1fvMuPA5GvP5cUe4PBu+Sg2/zjCrR+ASkoIzYjM8uyTUEVVsosBFTu1gN1pvx4Yx7OTlzyn1pD0QscvGadKmFFhIUAQZSWm940QSDMyaRqI8GQg9Zn6bp7WHqj8hP9PS+kviMqJtAg8QR45QNWgp07ANtn1ammeog7xum3gql6djnlBfD1CAQd4JHzM29G1Jk0btlHG0NhyvDeOyVjNbTa+y3dMcmWTtCJKmIxpiJjC0gD0xpnhaNLQEP//Z"
						style="width: 100%">
				</div>
				<div class="modal-footer"
					style="display: flex; justify-content: space-between;">
					<span class="modal-today-close"
						style="cursor: pointer; text-decoration: underline;"> 오늘 하루
						동안 보지 않기 </span> <span class="btn btn-default" data-dismiss="modal"
						id="modal-close">닫기</span>
				</div>
			</div>
		</div>
	</div>



	<div class="header">
		<div class="container header-nav">
			<div class="nav-logo">
				<a href="index.go"><img
					src="https://w.namu.la/s/8c5bc8129cf1dc5011dc8dad2e505c568e6be2c6c0bb9e9b6e9374df725639ffa359c16b9546536fe381f7982379d980b90fc1b2b3ff3bbe5d0c05377bdda69039472251a5b54f1a39d388a657f38149"
					style="width: 70px;"></a>
			</div>
			<div class="nav">
				<li class="nav-item dropdown flex"><a
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
					role="button" aria-expanded="false" style="color: black;">SHOP</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">보충제</a></li>
						<li><a class="dropdown-item" href="#">그립/스트랩</a></li>
						<li><a class="dropdown-item" href="#">팔꿈치 보호대</a></li>
						<li><a class="dropdown-item" href="#">등/허리</a></li>
						<li><a class="dropdown-item" href="#">무릎 보호대</a></li>
						<li><a class="dropdown-item" href="#">신발</a></li>
					</ul> <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
					href="#" role="button" aria-expanded="false" style="color: black;">헬스장
						정보</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">Separated link</a></li>
					</ul> <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
					href="#" role="button" aria-expanded="false" style="color: black;">커뮤니티</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">Separated link</a></li>
					</ul> <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
					href="#" role="button" aria-expanded="false" style="color: black;">대회/운동
						루틴</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">건우씨 짱</a></li>
					</ul></li>

			</div>
			<div class="nav-login">
				<div class="login-item01">
					<a href="member.login.go">로그인</a>
				</div>
				<div class="login-item02">
					<a href="#"><i class="fa-solid fa-cart-shopping"
						style="color: black;"><span>장바구니</span></i></a>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 70px; padding-bottom: 300px;">
		<jsp:include page="${contentPage }"></jsp:include>

	</div>

	<footer
		style="background-color: black; color: white; bottom: 0px; height: 300px; position: relative;">
		<div class="container">
			<div class="pb-5 pt-5 first-line">
				<h1 style="color: white; font-family: facon">Pumping Iron</h1>
			</div>
			<div class="pb-5 pt-5 second-line">
				<div class="row">
					<div class="col">주소 및 연락처 : 서울특별시 종로구 종로12길 15 8F 802호 /
						1544-0714</div>
				</div>
				<div class="row">
					<div class="col">멤버 : 최재식, 김건우, 김두현, 유제현</div>
				</div>
			</div>
			<div class="third-line pt-5 pb-5 text-center">
				<a href="index.go"><img
					src="https://w.namu.la/s/8c5bc8129cf1dc5011dc8dad2e505c568e6be2c6c0bb9e9b6e9374df725639ffa359c16b9546536fe381f7982379d980b90fc1b2b3ff3bbe5d0c05377bdda69039472251a5b54f1a39d388a657f38149"
					style="width: 70px;"></a>
			</div>
		</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>