#include <stdio.h>
#include <time.h>
#include <sys/sysinfo.h>

int main(int argc, char *argv[]) {
   printf("*****************************\n");
   printf("*** ACO350 - Htin Htet    ***\n");
   printf("***  System Info Utility  ***\n");
   printf("*****************************\n\n");
	time_t t1;
	struct tm *dp;
	struct sysinfo pc;
	float days;
	float usable;
	float available;
	float shared;
	float buffs;
	float totalS;
	float SwAv;
	char buffer[30];
	char buffer2[30];

	time(&t1);
	dp = localtime(&t1);
	sysinfo(&pc);

	strftime(buffer, sizeof buffer, "%A, %B %d, %Y", localtime(&t1));
	strftime(buffer2, sizeof buffer2, "%H:%M:%S", localtime(&t1));
	printf("Current Date: %s \n", buffer);
	printf("Current Time: %s \n", buffer2);

	days = pc.uptime/86400.0;
	usable = pc.totalram/1000000000.0;
	available = pc.freeram/1000000000.0;
	shared = pc.sharedram;	
	buffs = pc.bufferram/1000000.0;	
	totalS = pc.totalswap/1000000.0;
	SwAv = pc.freeswap/1000000.0;

	printf("Last Reboot: %d seconds, (%0.2f) days \n\n",pc.uptime, days);
	printf("Number of processors configured: %d \n", get_nprocs_conf());
	printf("Number of processors available : %d \n", get_nprocs());
	printf("Number of current processes    : %d \n\n", pc.procs);
	printf("Total usable memory size: %0.3f GB \n", usable);
	printf("Available memory size   : %0.3f GB \n", available);
	printf("Amount of shared memory : %0.3f MB \n", pc.sharedram/1000000.0);
	printf("Memory used by buffers	: %0.3f MB \n", buffs);
	printf("Total swap space size	: %0.3f MB \n", totalS);
	printf("Swao space available	: %0.3f MB \n", SwAv);


   return 0;
}

