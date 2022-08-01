#!/bin/bash
mount -t tmpfs     none    /dev
mount -t proc      none    /proc
mount -t sysfs     none    /sys
mdev -s

echo "****** Mounting filesystem ******" > dev/console
mkdir /newroot
mount /dev/mmcblk0p2 /newroot/

echo "****** Moving folders ******" > dev/console
mount --move /sys /newroot/sys/
mount --move /proc /newroot/proc/
mount --move /dev /newroot/dev/

echo "****** Performing Switch Root ******" > dev/console
exec switch_root /newroot /sbin/init