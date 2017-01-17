/*
This class is based on the ATK class, in fact it only changes the name to HOA ;-) Thank you ATK!
*/


HOA {
	classvar <userSupportDir, <userSoundsDir, <userKernelDir;
	classvar <systemSupportDir, <systemSoundsDir, <systemKernelDir;

	*initClass {
		userSupportDir = Platform.userAppSupportDir.dirname ++ "/HOA";		userSoundsDir = userSupportDir ++ "/sounds";
		userKernelDir = userSupportDir ++ "/kernels";
		systemSupportDir = Platform.systemAppSupportDir.dirname ++ "/HOA";		systemSoundsDir = systemSupportDir ++ "/sounds";
		systemKernelDir = systemSupportDir ++ "/kernels";
	}

	*userSupportDir_ {arg userSupportDirIn;
		userSupportDir = userSupportDirIn;
		userSoundsDir = userSupportDir ++ "/sounds";
		userKernelDir = userSupportDir ++ "/kernels";
	}

	*systemSupportDir_ {arg systemSupportDurIn;
		systemSupportDir = systemSupportDurIn;
		systemSoundsDir = systemSupportDir ++ "/sounds";
		systemKernelDir = systemSupportDir ++ "/kernels";
	}

	*openUserSupportDir {
		File.exists(Atk.userSupportDir).if({
			HOA.userSupportDir.openOS;
		}, {
			"User Support Dir may not exist. Run \n\tHOA.createUserSupportDir\nto create it".warn
		})
	}

	*createUserSupportDir {
		File.mkdir(HOA.userSupportDir);
//		("mkdir \"" ++ HOA.userSupportDir ++ "\"").unixCmd;
	}

	*openSystemSupportDir {
		File.exists(Atk.systemSupportDir).if({
			Atk.systemSupportDir.openOS;
		}, {
			"System Support Dir may not exist.".warn
		})
	}
}